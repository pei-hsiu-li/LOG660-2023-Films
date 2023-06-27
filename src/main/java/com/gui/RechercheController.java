package com.gui;

import com.hibernate.*;
import com.utils.JdbcSingleton;
import com.utils.Recommendation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import org.hibernate.Session;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import static com.test.disableLogging;

/**
 * Controller qui va changer de scene de RechercheUI a FilmDescriptionUI
 */

public class RechercheController {

    private RechercheUI rechercheUI;
    private FilmDescriptionUI filmDescriptionUI;
    private ListView<String> myListView;
    private String filmSelected;


    public RechercheController(RechercheUI rechercheUI, FilmDescriptionUI filmDescriptionUI) {

        this.rechercheUI = rechercheUI;
        this.filmDescriptionUI = filmDescriptionUI;
        rechercheUI.getSearchButton().setOnAction(new RechercheButtonHandler());
        rechercheUI.getConsultButton().setOnAction(new ConsultButtonHandler());
        rechercheUI.getListViewItem().getSelectionModel().selectedItemProperty().addListener((o, prev, value) -> {
            if (value != null)
                filmSelected = value.toString();
        });

    }

    private List<FilmEntity> rechercheFilm(String title, int anneeMin, int anneeMax, String pays, String langue, String genre, String realisateur, String acteur) {
        disableLogging();

        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        String hql = "FROM FilmEntity AS f JOIN f.pays p JOIN f.genres g WHERE 0=0";

        if (title.length() > 0){
            if (!title.contains(";"))
                hql += " AND f.titre LIKE '%" + title + "%'";
            else {
                String[] substrings = title.split(";");
                hql += " AND ";
                for (int i = 0; i < substrings.length; i++) {
                    hql += " f.titre LIKE '%" + substrings[i] + "%'";
                    if (i != substrings.length - 1) {
                        hql += " OR ";
                    }
                }
            }
        }
        if (anneeMin > 0)
            hql += " AND f.anneesortie >= " + anneeMin;
        if (anneeMax > 0)
            hql += " AND f.anneesortie <= " + anneeMax;
        if (pays.length() > 0) {
            if (!pays.contains(";"))
                hql += " AND p.pays LIKE '%" + pays + "%'";
            else {
                String[] substrings = pays.split(";");
                hql += " AND ";
                for (int i = 0; i < substrings.length; i++) {
                    hql += " p.pays  LIKE '%" + substrings[i] + "%'";
                    if (i != substrings.length - 1) {
                        hql += " OR ";
                    }
                }
            }
        }
        if (langue.length() > 0) {
            if (!langue.contains(";"))
                hql += " AND f.langue LIKE '%" + langue + "%'";
            else {
                String[] substrings = langue.split(";");
                hql += " AND ";
                for (int i = 0; i < substrings.length; i++) {
                    hql += " f.langue LIKE '%" + substrings[i] + "%'";
                    if (i != substrings.length - 1) {
                        hql += " OR ";
                    }
                }
            }
        }

        if (genre.length() > 0) {
            if (!genre.contains(";"))
                hql += " AND g.genre LIKE '%" + genre + "%'";
            else {
                String[] substrings = genre.split(";");
                hql += " AND ";
                for (int i = 0; i < substrings.length; i++) {
                    hql += " g.genre LIKE '%" + substrings[i] + "%'";
                    if (i != substrings.length - 1) {
                        hql += " OR ";
                    }
                }
            }
        }

        if (realisateur.length() > 0) {
            String sql = "SELECT a.idartiste FROM ArtisteEntity AS a WHERE CONCAT(a.prenom, CONCAT(' ', a.nom)) LIKE";

            String[] substrings = realisateur.split(";");
            sql += " '%" + substrings[0] + "%'";
            for (int i = 1; i < substrings.length; i++) {
                sql += " OR CONCAT(a.prenom, CONCAT(' ', a.nom)) LIKE'%" + substrings[i] + "%'";
            }

            String realisateurSQL = realisateurSQL = "SELECT fa.idfilm FROM FilmartisteEntity AS fa WHERE fa.idartiste IN (" + sql + ") AND fa.metier LIKE 'Realisateur'";
            hql += " AND f.idfilm IN(" + realisateurSQL + ")";
        }
        if (acteur.length() > 0) {
            String sql = "SELECT a.idartiste FROM ArtisteEntity AS a WHERE CONCAT(a.prenom, CONCAT(' ', a.nom)) LIKE";

            String[] substrings = acteur.split(";");
            sql += " '%" + substrings[0] + "%'";
            for (int i = 1; i < substrings.length; i++) {
                sql += " OR CONCAT(a.prenom, CONCAT(' ', a.nom)) LIKE '%" + substrings[i] + "%'";
            }

            String realisateurSQL = "SELECT fa.idfilm FROM FilmartisteEntity AS fa WHERE fa.idartiste IN (" + sql + ") AND fa.metier LIKE 'Acteur'";
            hql += " AND f.idfilm IN(" + realisateurSQL + ")";
        }

        List<FilmEntity> lesFilms = ss.createQuery(hql).list();

        ss.getTransaction().commit();
        ss.close();
        return lesFilms;
    }

    private FilmEntity infoFilm(String titre) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        String hql = "FROM FilmEntity WHERE titre LIKE '" + titre + "'";

        FilmEntity film = (FilmEntity) ss.createQuery(hql).getSingleResult();
        ss.getTransaction().commit();
        ss.close();

        return film;
    }

    private String nomRealisateur(BigInteger idFilm) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        String hql = "FROM ArtisteEntity AS a WHERE a.idartiste LIKE (SELECT fa.idartiste FROM FilmartisteEntity AS fa WHERE fa.idfilm LIKE '" + idFilm + "' AND metier LIKE 'Realisateur')";

        ArtisteEntity artiste = (ArtisteEntity) ss.createQuery(hql).getSingleResult();
        ss.getTransaction().commit();
        ss.close();

        return artiste.getPrenom() + " " + artiste.getNom();
    }

    class RechercheButtonHandler implements EventHandler<ActionEvent> {

        //Faire les queries avec les selects et if(true) alors le boutton rechercher change de scene a consultationFilmsUI, sinon on affiche un message d'erreur
        @Override
        public void handle(ActionEvent e) {

            rechercheUI.listView.getItems().clear();

            List lesFilms = rechercheFilm(rechercheUI.titleField.getText(), Integer.parseInt(rechercheUI.anneeMinField.getText()), Integer.parseInt(rechercheUI.anneeMaxField.getText()),
                    rechercheUI.paysField.getText(), rechercheUI.languageField.getText(), rechercheUI.genreField.getText(),
                    rechercheUI.realisateurField.getText(), rechercheUI.acteurField.getText());

            if (lesFilms.size() > 0) {
                System.out.println(lesFilms.size() + " films trouvés:");

                for (Iterator it = lesFilms.iterator(); it.hasNext(); ) {
                    FilmEntity unFilmCharge = (FilmEntity) it.next();
                    rechercheUI.listItems.add(unFilmCharge.getTitre() + " (" + unFilmCharge.getAnneesortie() + ")");

                }
                rechercheUI.listView = new ListView<>(rechercheUI.listItems);
                myListView = rechercheUI.listView;
                rechercheUI.totalField.setText(lesFilms.size() + "");

            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Critère error");
                errorAlert.setContentText("Aucun film trouvé!");
                errorAlert.showAndWait();
            }
        }
    }

    class ConsultButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (filmSelected.length() > 7) {

                filmSelected = filmSelected.substring(0, filmSelected.length() - 7);
                //GetFilmNameSingleton.setFilm(filmSelected);
                FilmEntity film = infoFilm(filmSelected);
                String realisateur = nomRealisateur(film.getIdfilm());

                filmDescriptionUI.setTitreFilm(film.getTitre());
                filmDescriptionUI.setAnneeSortieTxt(film.getAnneesortie() + "");
                filmDescriptionUI.setDureeTxt(film.getDuree() + " minutes");
                filmDescriptionUI.setLangueTxt(film.getLangue());
                filmDescriptionUI.setResumeTxt(film.getResume());
                filmDescriptionUI.setPosterTxt(film.getAffiche());
                filmDescriptionUI.setRealisateurTxt(realisateur);

                Session ss = HibernateUtil.getSessionFactory().openSession();
                FilmEntity newSSFilm = ss.get(FilmEntity.class, film.getIdfilm());

                for (Iterator it = newSSFilm.getPays().iterator(); it.hasNext(); ) {
                    PaysEntity entity = (PaysEntity) it.next();
                    filmDescriptionUI.paysListItems.add(entity.getPays());
                }
                filmDescriptionUI.setPaysProductionList(new ListView<>(filmDescriptionUI.paysListItems));

                for (Iterator it = newSSFilm.getGenres().iterator(); it.hasNext(); ) {
                    GenreEntity entity = (GenreEntity) it.next();
                    filmDescriptionUI.genListItems.add(entity.getGenre());
                }
                filmDescriptionUI.setGenreList(new ListView<>(filmDescriptionUI.genListItems));

                for (Iterator it = newSSFilm.getRoleArtistes().iterator(); it.hasNext(); ) {
                    FilmartisteEntity entity = (FilmartisteEntity) it.next();
                    ArtisteEntity artiste = ss.get(ArtisteEntity.class, entity.getIdartiste());
                    if (entity.getMetier().equals("Scenariste"))
                        filmDescriptionUI.scenListItems.add(artiste.getPrenom() + " " + artiste.getNom());
                    else if (entity.getMetier().equals("Acteur")) {
                        filmDescriptionUI.actListItems.add(artiste.getPrenom() + " " + artiste.getNom());
                        filmDescriptionUI.roleListItems.add(entity.getPersonnage());
                    }
                }
                filmDescriptionUI.setScenaristeList(new ListView<>(filmDescriptionUI.scenListItems));
                filmDescriptionUI.setActeursList(new ListView<>(filmDescriptionUI.actListItems));
                filmDescriptionUI.setRolesList(new ListView<>(filmDescriptionUI.roleListItems));

                for (Iterator it = newSSFilm.getBandeAnnonces().iterator(); it.hasNext(); ) {
                    BandeannonceEntity entity = (BandeannonceEntity) it.next();
                    filmDescriptionUI.bandListItems.add(entity.getLienbandeannonce());
                }
                filmDescriptionUI.setBandeAnnonceList(new ListView<>(filmDescriptionUI.bandListItems));

                /**
                 * TO-DO : REQUETE POUR ALLER CHERCHER LA COTE ET LES 3 RECOMMANDATIONS DE FILMS
                 */
                //Tu fais ta requete pour la cote moyenne et la stocke dans une variable ici
                //exemple -> int requeteCote = SELECT "" FROM ...
                //Tu set le texte du textfield de la cote

                try {
                    Recommendation recommendation = new Recommendation();

                    filmDescriptionUI.getCoteTextField().setText(""+ recommendation.getCote(film.getIdfilm().intValue()));

                    String[] filmRecommander = recommendation.getRecommendation(film.getIdfilm().intValue());
                    filmDescriptionUI.getRecommandationFilm1TextField().setText(filmRecommander[0]);
                    filmDescriptionUI.getRecommandationFilm2TextField().setText(filmRecommander[1]);
                    filmDescriptionUI.getRecommandationFilm3TextField().setText(filmRecommander[2]);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                //tu fais pareille pour recommandation 1,2 et 3 (les get sont dans la classe FilmDescriptionUI)


                ss.close();
                Main.changeScene(new Scene(filmDescriptionUI, 1200, 800));
            }
        }
    }
}
