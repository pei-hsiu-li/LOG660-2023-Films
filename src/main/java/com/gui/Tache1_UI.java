package com.gui;

import com.utils.Analytics;
import com.utils.JdbcSingleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.SQLException;


public class Tache1_UI extends GridPane {

    // Création des champs de texte et des étiquettes correspondantes
    Button backButton = new Button("Retour au choix de tache");
    // ------------------------------------------
    ObservableList<String> optionsAge =
            FXCollections.observableArrayList(
                    "20-25", "25-30", "30-35", "35-40", "40-45", "tous"
            );
    ComboBox tranchesAge = new ComboBox(optionsAge);
    Label tranchesAgeLabel = new Label("Tranche Age 5 ans:");
    // ------------------------------------------
    // ------------------------------------------
    ObservableList<String> optionsProvince =
            FXCollections.observableArrayList(
                    "quebec", "ontario", "manitoba", "saskatchewan", "alberta", "tous"
            );
    ComboBox provinceField = new ComboBox(optionsProvince);
    Label provinceLabel = new Label("Province:");
    // ------------------------------------------
    // ------------------------------------------
    ObservableList<String> optionsDays =
            FXCollections.observableArrayList(
                    "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche", "tous"
            );
    ComboBox dayOfWeekField = new ComboBox(optionsDays);
    Label dayOfWeekLabel = new Label("Jour de la semaine:");
    // ------------------------------------------
    // ------------------------------------------
    ObservableList<String> optionsMonths =
            FXCollections.observableArrayList(
                    "janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre", "tous"
            );
    ComboBox monthField = new ComboBox(optionsMonths);
    Label monthLabel = new Label("Mois dans l'annee:");
    // ------------------------------------------
    GridPane grid = new GridPane();
    // Création du bouton de recherche
    Button searchButton = new Button("Rechercher");
    // Création du champ de texte pour le nombre de locations
    TextField numLocationsField = new TextField();
    Label numLocationsLabel = new Label("Nombre de locations:");
    // Création de la boîte horizontale pour le bouton de recherche
    HBox searchBox = new HBox(searchButton);
    // Création de la boîte verticale pour les composants à droite de la fenêtre
    VBox rightBox = new VBox(numLocationsLabel, numLocationsField, searchBox);
    // Création de la boîte horizontale pour les deux colonnes
    HBox hbox = new HBox(grid, rightBox);

    public Tache1_UI(){
        /**
         * TO-DO : IMPLEMENTER searchButton
         */
        // ICI NOUS ALLONS IMPLEMENTER LE BOUTON POUR FAIRE LA REQUETE A LA DB
        searchButton.setOnAction(e -> {
            // Ajouter le code pour rechercher le nombre de locations correspondant aux critères dans la base de donnees
            // Stocker ce nombre dans une variable "nombreLocations"
            // On peut ensuite afficher ce nombre dans le champ de texte de "numLocationsField" avec le code ci-dessous
            // numLocationsField.setText(Integer.toString(nombreLocations));
            try {
                Analytics analytics = new Analytics();

                String age = tranchesAge.getValue().toString();
                String province = provinceField.getValue().toString();
                String day = dayOfWeekField.getValue().toString();
                String month = monthField.getValue().toString();

                int count = analytics.get(age, province, day, month);

                numLocationsField.setText(Integer.toString(count));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        backButton.setOnAction(e -> {
            Main.restartTache();
        });

        // On appele la methode qui met en place le Grid et la boite dans la fenetre
        setWindow();
    }

    private void setWindow(){
        // Création de la grille pour organiser les composants
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // Ajout des composants à la grille
        grid.add(tranchesAgeLabel, 0, 0);
        grid.add(tranchesAge, 1, 0);
        grid.add(provinceLabel, 0, 1);
        grid.add(provinceField, 1, 1);
        grid.add(dayOfWeekLabel, 0, 2);
        grid.add(dayOfWeekField, 1, 2);
        grid.add(monthLabel, 0, 3);
        grid.add(monthField, 1, 3);
        grid.add(backButton,1,6);

        // Empecher la modification de location field
        numLocationsField.setEditable(false);

        // Modification du box
        searchBox.setAlignment(Pos.CENTER_RIGHT);
        rightBox.setSpacing(10);
        rightBox.setPadding(new Insets(10));
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(20);

        // Ajout des composants dans la grille
        this.add(hbox, 0, 0);
        this.setHgap(20);
        this.setVgap(20);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
    }
}
