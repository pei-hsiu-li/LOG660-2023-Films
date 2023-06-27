package com.gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * UI POUR LA RECHERCHE DE FILM (PAGE 2)
 */

public class RechercheUI extends GridPane{

    Button searchButton;
    Button consultButton;
    Label titleLabel;
    Label genreLabel;
    Label acteurLabel;
    Label realisateurLabel;
    Label paysLabel;
    Label languageLabel;
    Label anneeMinLabel;
    Label anneeMaxLabel;
    TextField titleField;
    TextField genreField;
    TextField acteurField;
    TextField realisateurField;
    TextField paysField;
    TextField languageField;
    TextField anneeMinField;
    TextField anneeMaxField;
    TextField totalField;
    Label totalLable;

    ObservableList<String> listItems = FXCollections.observableArrayList();
    ListView<String> listView = new ListView<>(listItems);


    public RechercheUI() {
        setGrid();
        createAttributes();
        addAttributes();

    }

    private void setGrid(){
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
    }

    private void createAttributes(){
        //Creation du button
        searchButton = new Button("Rechercher");
        setHalignment(searchButton, HPos.RIGHT);
        consultButton = new Button("Consulter");
        //consultButton.setDisable(true);
        setHalignment(consultButton, HPos.RIGHT);

        //Creation des labels
        titleLabel = new Label("Titre:");
        genreLabel = new Label("Genre:");
        acteurLabel = new Label("Acteur:");
        realisateurLabel = new Label("Realisateur");
        paysLabel = new Label("Pays:");
        languageLabel = new Label("Langue:");
        anneeMinLabel = new Label("Année min:");
        anneeMaxLabel = new Label("Année max:");
        totalLable = new Label("Films trouvés:");

        //Creation des TextField
        titleField = new TextField();
        genreField = new TextField();
        acteurField = new TextField();
        realisateurField = new TextField();
        paysField = new TextField();
        languageField = new TextField();
        anneeMinField = new TextField("0");
        totalField = new TextField("0");
        totalField.setEditable(false);
        totalField.setMaxWidth(50);

        anneeMinField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    anneeMinField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        anneeMaxField = new TextField("0");
        anneeMaxField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    anneeMaxField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        listView.setPrefSize(400,200);
    }

    private void addAttributes(){
        add(titleLabel, 0, 0);
        add(titleField, 1, 0);
        add(anneeMinLabel, 0, 1);
        add(anneeMinField, 1, 1);
        add(anneeMaxLabel, 0, 2);
        add(anneeMaxField, 1, 2);
        add(paysLabel, 0, 3);
        add(paysField, 1, 3);
        add(languageLabel, 0, 4);
        add(languageField, 1, 4);
        add(genreLabel, 0, 5);
        add(genreField, 1, 5);
        add(acteurLabel, 0, 6);
        add(acteurField, 1, 6);
        add(realisateurLabel,0,7);
        add(realisateurField,1,7);
        add(searchButton, 1, 8);
        add(totalLable, 2, 8, 1, 1);
        add(totalField, 3, 8,1,1);
        add(listView,2,0, 2, 8);
        add(consultButton, 3, 8,1,1);
    }

    public Button getSearchButton(){ return searchButton; }
    public Button getConsultButton(){
        return consultButton;
    }
    public ListView getListViewItem(){
        return listView;
    }
}
