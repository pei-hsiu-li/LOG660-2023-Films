package com.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * UI POUR CONSULTER LA DESCRIPTION DES ARTISTES (ACTEURS OU REALISATEURS) - PAGE 4A SELON LE SCHEMA
 */

public class ArtisteDescriptionUI extends GridPane {
    private Label nomLabel;
    private Label nomTestLabel;
    private Label prenomLabel;
    private Label prenomTestLabel;
    private Label dateNaissanceLabel;
    private Label dateNaissanceTestLabel;
    private Label lieuNaissanceLabel;
    private Label lieuNaissanceTestLabel;
    private Label photoLabel;
    private Label photoTestLabel;
    private Label biographieLabel;
    private Label biographieTestLabel;

    public ArtisteDescriptionUI() {
        createAttributes();
        setGrid();
        addAttributesToGrid();
    }

    private void createAttributes() {
        nomLabel = new Label("Nom : ");
        nomTestLabel = new Label("test");
        prenomLabel = new Label("Prenom : ");
        prenomTestLabel = new Label("test");
        dateNaissanceLabel = new Label("Date de naissance : ");
        dateNaissanceTestLabel = new Label("test");
        lieuNaissanceLabel = new Label("Lieu de naissance : ");
        lieuNaissanceTestLabel = new Label("test");
        photoLabel = new Label("Photo : ");
        photoTestLabel = new Label("test");
        biographieLabel = new Label("Biographie : ");
        biographieTestLabel = new Label("test");
    }

    private void setGrid() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
    }

    private void addAttributesToGrid() {
        setPadding(new Insets(20, 20, 20, 20));
        add(nomLabel, 0, 0);
        add(nomTestLabel, 1, 0);
        add(prenomLabel, 0, 1);
        add(prenomTestLabel, 1, 1);
        add(dateNaissanceLabel, 0, 2);
        add(dateNaissanceTestLabel, 1, 2);
        add(lieuNaissanceLabel, 0, 3);
        add(lieuNaissanceTestLabel, 1, 3);
        add(photoLabel, 0, 4);
        add(photoTestLabel, 1, 4);
        add(biographieLabel, 0, 5);
        add(biographieTestLabel, 1, 5);
    }
}


