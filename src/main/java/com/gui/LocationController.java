package com.gui;

import com.hibernate.ArtisteEntity;
import com.hibernate.FilmEntity;
import com.hibernate.HibernateUtil;
import com.hibernate.LocationEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * Controller qui va gerer le bouton Louer
 */

public class LocationController {
    private FilmDescriptionUI filmDescriptionUI;

    public LocationController(FilmDescriptionUI filmDescriptionUI) {

        this.filmDescriptionUI = filmDescriptionUI;
        filmDescriptionUI.getLouerButton().setOnAction(new LouerBoutonHandler());
        filmDescriptionUI.getForfaitsButton().setOnAction(new ForfaitsButtonHandler());

        filmDescriptionUI.getScenaristeList().getSelectionModel().selectedItemProperty().addListener((o, prev, value) -> {
            if (value != null) {
                infoArtiste(value);
            }
        });

        filmDescriptionUI.getActeursList().getSelectionModel().selectedItemProperty().addListener((o, prev, value) -> {
            if (value != null) {
                infoArtiste(value);
            }
        });

        filmDescriptionUI.getRealisateurTxt().setOnMouseClicked(mouseEvent -> {
            if (filmDescriptionUI.getRealisateurTxt().getText() != null) {
                infoArtiste(filmDescriptionUI.getRealisateurTxt().getText());
            }
        });
    }


    public void infoArtiste(String nom) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        String hql = "FROM ArtisteEntity AS a WHERE CONCAT(a.prenom, CONCAT(' ', a.nom)) LIKE '" + nom + "'";

        ArtisteEntity artiste = (ArtisteEntity) ss.createQuery(hql).getSingleResult();
        ss.getTransaction().commit();
        ss.close();

        filmDescriptionUI.infoArtiste.setTitle(artiste.getPrenom() + " " + artiste.getNom());
        filmDescriptionUI.infoArtiste.setHeaderText(null);
        String info = "Date de naissance: " + artiste.getDatedenaissance() + "\n";
        info += "Lieu de naissance: " + artiste.getDatedenaissance() + "\n";
        info += "Photo: " + artiste.getPhoto() + "\n";
        info += "Biographie: " + artiste.getBiographie() + "";
        filmDescriptionUI.infoArtiste.setResizable(true);

        //filmDescriptionUI.infoArtiste.setContentText(info);

        filmDescriptionUI.infoArtiste.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(info)));

        filmDescriptionUI.infoArtiste.showAndWait();;
    }

    class LouerBoutonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            // Get nom film, trouve codeFilm valide, insère location

            // Get idClient
            Auth auth = Auth.getInstance();
            BigInteger idClient = auth.getAuthUserId();

            // nom film -> idFilm
            String nomFilm = filmDescriptionUI.getNomFilm();
            BigInteger idFilm = getIdFilm(nomFilm);

            // idFilm -> codeFilm disponible
            List<Integer> codes = getCodesFilm(idFilm);

            if (codes.size() == 0) {
                alert("Aucune copie du film n'est disponible.");
                return;
            }

            int codeFilm = codes.get(0);

            String msg = doLocation(idClient, codeFilm);
            alert(msg);
        }

        private void alert(String msg) {
            //Message pour dire que la location a ete fait
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText(msg);
            successAlert.showAndWait();
        }

        private BigInteger getIdFilm(String nom) {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();

            // SELECT les codeFilm d'un idFilm qui ne sont pas déjà louer
            String hql = "FROM FilmEntity AS f WHERE f.titre ='" + nom + "'";
            FilmEntity film = (FilmEntity) ss.createQuery(hql).list().get(0);

            ss.close();
            return film.getIdfilm();
        }

        private List<Integer> getCodesFilm(BigInteger idFilm) {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();

            // SELECT les codeFilm d'un idFilm qui ne sont pas déjà louer
            String hql = "SELECT c.codefilm FROM CopiephysiquefilmEntity AS c WHERE c.idfilm = " + idFilm + " AND c.codefilm NOT IN (SELECT l.codefilm FROM LocationEntity AS l)";
            List<Integer> copiesFilm = ss.createQuery(hql).list();

            ss.close();
            return copiesFilm;
        }

        private String doLocation(BigInteger idClient, int codeFilm) {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();

            // Ajoute location
            LocationEntity location = new LocationEntity();
            location.setIdclient(idClient);
            location.setCodefilm(codeFilm);

            // Set up date
            Date datePret = new Date(System.currentTimeMillis());
            location.setDatepret(datePret);
            location.setDateretour(null);

            // Message de retour generic
            String message = "Location réussi";

            // commit
            try {
                ss.save(location);
                ss.getTransaction().commit();
            } catch (Exception e) {
                // extract message d'erreur du trigger
                String[] errTab = e.getCause().getCause().toString().split(":");
                String[] errMsg = errTab[2].split("\n");
                message = errMsg[0];
            }

            ss.close();
            return message;
        }

    }

    class ForfaitsButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Stage newStage = new Stage();
            newStage.setScene(new Scene(new ForfaitsUI(), 400, 200));
            newStage.show();
        }
    }
}
