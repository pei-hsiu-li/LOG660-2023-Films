package com.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;

/**
 * UI POUR LA CONSULTATION DES FORFAITS (PAGE 4C selon schema)
 */

public class FilmDescriptionUI extends GridPane {

    ObservableList<String> paysListItems = FXCollections.observableArrayList();
    ListView<String> paysProductionList = new ListView<>(paysListItems);
    ObservableList<String> genListItems = FXCollections.observableArrayList();
    ListView<String> genreList = new ListView<>(genListItems);
    ObservableList<String> scenListItems = FXCollections.observableArrayList();
    ListView<String> scenaristeList = new ListView<>(scenListItems);
    ObservableList<String> actListItems = FXCollections.observableArrayList();
    ListView<String> acteursList = new ListView<>(actListItems);
    ObservableList<String> roleListItems = FXCollections.observableArrayList();
    ListView<String> rolesList = new ListView<>(roleListItems);
    ObservableList<String> bandListItems = FXCollections.observableArrayList();
    ListView<String> bandeAnnonceList = new ListView<>(bandListItems);
    private Label titreFilmLabel;
    private Label titreTxt;
    private Label anneeSortieLabel;
    private Label anneeSortieTxt;
    private Label paysProductionLabel;
    private Label langueOriginaleLabel;
    private Label langueTxt;
    private Label dureeFilmLabel;
    private Label dureeTxt;
    private Label genresFilmLabel;
    private Label realisateurLabel;
    private Hyperlink realisateurTxt;
    private Label scenaristesLabel;
    private Label acteursLabel;
    private Label rolesLabel;
    private Label resumeLabel;
    private Label resumeTxt;
    private Label bandeAnnonceLabel;
    private Label afficheLabel;
    private Hyperlink posterTxt;
    private Button louerButton;
    private Button backButton;
    private Button forfaitsButton;
    private Label coteLabel;
    private TextField coteTextField;


    private Label recommandationFilm1Label;
    private TextField recommandationFilm1TextField;

    private Label recommandationFilm2Label;
    private TextField recommandationFilm2TextField;

    private Label recommandationFilm3Label;
    private TextField recommandationFilm3TextField;


    Alert infoArtiste = new Alert(Alert.AlertType.INFORMATION);


    public FilmDescriptionUI() {
        setGrid();
        createAttributes();
        addAttributesToGrid();

        backButton.setOnAction(e -> {
            Main.restartTache();
        });

    }

    private void setGrid() {
        this.setHgap(10);
        this.setVgap(5);
    }

    private void createAttributes() {
        titreFilmLabel = new Label("Titre du film :");
        anneeSortieLabel = new Label("Année de sortie du film :");
        paysProductionLabel = new Label("Pays de production :");
        langueOriginaleLabel = new Label("Langue originale du film :");
        dureeFilmLabel = new Label("Durée du film :");
        genresFilmLabel = new Label("Genres du film :");
        realisateurLabel = new Label("Réalisateur :");
        scenaristesLabel = new Label("Scénaristes :");
        acteursLabel = new Label("Acteurs :");
        rolesLabel = new Label("Rôle joué :");
        resumeLabel = new Label("Résumé :");
        bandeAnnonceLabel = new Label("Bande-annonce :");
        afficheLabel = new Label("Affiche :");
        louerButton = new Button("Louer");
        backButton = new Button("Retour au choix de tache");
        forfaitsButton = new Button("Consultez nos forfaits !");

        //Cote moyenne
        coteLabel = new Label("Cote moyenne");
        coteTextField = new TextField();
        coteTextField.setEditable(false);

        //Recommandations
        recommandationFilm1Label = new Label("Recommandation Film 1");
        recommandationFilm1TextField = new TextField();
        recommandationFilm1TextField.setEditable(false);
        recommandationFilm2Label = new Label("Recommandation Film 2");
        recommandationFilm2TextField = new TextField();
        recommandationFilm2TextField.setEditable(false);
        recommandationFilm3Label = new Label("Recommandation Film 3");
        recommandationFilm3TextField = new TextField();
        recommandationFilm3TextField.setEditable(false);

        titreTxt = new Label("Test");
        anneeSortieTxt = new Label("Test");
        paysProductionList.setPrefSize(100, 30);
        paysProductionList.setOrientation(Orientation.HORIZONTAL);
        langueTxt = new Label("Test");
        dureeTxt = new Label("Test");
        genreList.setPrefSize(100, 30);
        genreList.setOrientation(Orientation.HORIZONTAL);
        realisateurTxt = new Hyperlink("Test");
        scenaristeList.setPrefSize(300, 100);
        scenaristeList.setOrientation(Orientation.HORIZONTAL);
        acteursList.setPrefSize(300, 100);
        rolesList.setPrefSize(300, 100);
        resumeTxt = new Label("Test");
        bandeAnnonceList.setPrefSize(300, 90);
        bandeAnnonceList.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Hyperlink hyperlink = new Hyperlink(item);
                    setGraphic(hyperlink);
                }
            }
        });
        posterTxt = new Hyperlink();
    }

    private void addAttributesToGrid() {
        add(titreFilmLabel, 0, 0);
        add(titreTxt, 1, 0);
        add(anneeSortieLabel, 0, 1);
        add(anneeSortieTxt, 1, 1);
        add(paysProductionLabel, 0, 2);
        add(paysProductionList, 1, 2);
        add(langueOriginaleLabel, 0, 3);
        add(langueTxt, 1, 3);
        add(dureeFilmLabel, 0, 4);
        add(dureeTxt, 1, 4);
        add(genresFilmLabel, 0, 5);
        add(genreList, 1, 5,3,1);
        add(realisateurLabel, 0, 6);
        add(realisateurTxt, 1, 6);
        add(scenaristesLabel, 0, 7);
        add(scenaristeList, 1, 7,3,1);
        add(acteursLabel, 0, 8);
        add(acteursList, 1, 8,1,1);
        add(rolesLabel, 2, 8);
        add(rolesList, 3, 8,1,1);
        add(resumeLabel, 0, 9);
        add(resumeTxt, 1, 9,3,1);
        add(bandeAnnonceLabel, 0, 11);
        add(bandeAnnonceList, 1, 11,3,1);
        add(afficheLabel, 0, 12);
        add(posterTxt, 1, 12,3,1);
        add(coteLabel,0,14);
        add(coteTextField,1,14);
        add(recommandationFilm1Label,0,15);
        add(recommandationFilm1TextField,1,15);
        add(recommandationFilm2Label,0,16);
        add(recommandationFilm2TextField,1,16);
        add(recommandationFilm3Label,0,17);
        add(recommandationFilm3TextField,1,17);
        add(louerButton, 0, 20);
        add(backButton, 1, 20, 1, 2);
        add(forfaitsButton,2,20);
    }

    public Button getBackButton() {
        return backButton;
    }
    public Button getForfaitsButton(){
        return forfaitsButton;
    }
    public Button getLouerButton() {
        return louerButton;
    }
    public String getNomFilm() {
        return this.titreTxt.getText();
    }

    public void setTitreFilm(String titre) {
        this.titreTxt.setText(titre);
    }

    public void setAnneeSortieTxt(String anneeSortieTxt) {
        this.anneeSortieTxt.setText(anneeSortieTxt);
    }

    public void setPaysProductionList(ListView<String> paysProductionList) {
        this.paysProductionList = paysProductionList;
    }

    public void setLangueTxt(String langueTxt) {
        this.langueTxt.setText(langueTxt);
    }

    public void setDureeTxt(String dureeTxt) {
        this.dureeTxt.setText(dureeTxt);
    }

    public void setGenreList(ListView<String> genreList) {
        this.genreList = genreList;
    }

    public Hyperlink getRealisateurTxt() {
        return realisateurTxt;
    }

    public void setRealisateurTxt(String realisateurTxt) {
        this.realisateurTxt.setText(realisateurTxt);
    }

    public ListView<String> getScenaristeList() {
        return scenaristeList;
    }

    public void setScenaristeList(ListView<String> scenaristeList) {
        this.scenaristeList = scenaristeList;
    }

    public ListView<String> getActeursList() {
        return acteursList;
    }

    public void setActeursList(ListView<String> acteursList) {
        this.acteursList = acteursList;
    }
    public void setRolesList(ListView<String> rolesList) {
        this.rolesList = rolesList;
    }

    public void setResumeTxt(String resumeTxt) {
        this.resumeTxt.setText(resumeTxt);
    }

    public void setBandeAnnonceList(ListView<String> bandeAnnonceList) {
        this.bandeAnnonceList = bandeAnnonceList;
    }

    public void setPosterTxt(String posterTxt) {
        this.posterTxt.setText(posterTxt);
    }
    public TextField getCoteTextField(){
        return this.coteTextField;
    }

    public TextField getRecommandationFilm1TextField(){
        return this.recommandationFilm1TextField;
    }
    public TextField getRecommandationFilm2TextField(){
        return this.recommandationFilm2TextField;
    }
    public TextField getRecommandationFilm3TextField(){
        return this.recommandationFilm3TextField;
    }
}
