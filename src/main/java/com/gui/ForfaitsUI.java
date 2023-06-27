package com.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * UI POUR LA CONSULTATION DES FORFAITS (PAGE 4B selon schema)
 */

public class ForfaitsUI extends GridPane {

    private Label debutantLabel;
    private Label intermediaireLabel;
    private Label avanceLabel;
    private Label cinqLabel;
    private Label dixLabel;
    private Label quinzeLabel;
    private Label unFilmLabel;
    private Label cinqFilmsLabel;
    private Label dixFilmsLabel;
    private Label dixJoursLabel;
    private Label trenteJoursLabel;
    private Label illimiteLabel;
    private Label codeD_Label;
    private Label codeI_Label;
    private Label codeA_Label;
    private Button AbonnementButton;

    public ForfaitsUI() {

        setGrid();
        createAttributes();
        addAttributesToGrid();

    }

    private void createAttributes(){
        debutantLabel = new Label("Debutant");
        intermediaireLabel = new Label("Intermediaire");
        avanceLabel = new Label("Avance");
        cinqLabel = new Label("5$/mois");
        dixLabel = new Label("10$/mois");
        quinzeLabel = new Label("15$/mois");
        unFilmLabel = new Label("1 film");
        cinqFilmsLabel = new Label("5 films");
        dixFilmsLabel = new Label("10 films");
        dixJoursLabel = new Label("10 jours");
        trenteJoursLabel = new Label("30 jours");
        illimiteLabel = new Label("illimite");
        codeD_Label = new Label("D");
        codeI_Label = new Label("I");
        codeA_Label = new Label("A");
        AbonnementButton = new Button("S'abonner");
    }

    private void setGrid(){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10, 10, 10, 10));
    }

    private void addAttributesToGrid(){
        add(new Label("Forfaits"), 0, 0);
        add(new Label("Couts"), 1, 0);
        add(new Label("Locations max"), 2, 0);
        add(new Label("Duree max"), 3, 0);
        add(new Label("Code"), 4, 0);

        add(debutantLabel, 0, 1);
        add(intermediaireLabel, 0, 2);
        add(avanceLabel, 0, 3);

        add(cinqLabel, 1, 1);
        add(dixLabel, 1, 2);
        add(quinzeLabel, 1, 3);

        add(unFilmLabel, 2, 1);
        add(cinqFilmsLabel, 2, 2);
        add(dixFilmsLabel, 2, 3);

        add(dixJoursLabel, 3, 1);
        add(trenteJoursLabel, 3, 2);
        add(illimiteLabel, 3, 3);

        add(codeD_Label, 4, 1);
        add(codeI_Label, 4, 2);
        add(codeA_Label, 4, 3);

        add(AbonnementButton, 4, 4, 1, 5);
        setHalignment(AbonnementButton, HPos.RIGHT);
        AbonnementButton.setDisable(true);
    }

    public Button getAbonnementButton(){
        return AbonnementButton;
    }

}

