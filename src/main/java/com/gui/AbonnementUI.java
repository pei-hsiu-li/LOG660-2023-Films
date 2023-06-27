package com.gui;

/**
 * UI POUR LA CHOISIR ET PAYER SON ABONNEMENT
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class AbonnementUI extends GridPane {

    private RadioButton debutantButton;
    private RadioButton intermediaireButton;
    private RadioButton avanceButton;
    private Button payerButton;
    private TextField nomField;
    private TextField prenomField;
    private TextField courrielField;
    private TextField telephoneField;
    private TextField adresseField;
    private TextField ccTypeField;
    private TextField ccNumberField;
    private TextField ccExpirationField;
    private TextField ccCvvField;
    private TextField dateNaissanceField;
    private PasswordField motDePasseField;

    public AbonnementUI() {

        setGrid();
        setRadioButtons();
        createAttributes();
    }

    private void setGrid(){
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
    }

    private void setRadioButtons(){
        ToggleGroup niveauAbonnementToggle = new ToggleGroup();
        debutantButton = new RadioButton("Debutant");
        intermediaireButton = new RadioButton("Intermediaire");
        avanceButton = new RadioButton("Avance");
        debutantButton.setToggleGroup(niveauAbonnementToggle);
        intermediaireButton.setToggleGroup(niveauAbonnementToggle);
        avanceButton.setToggleGroup(niveauAbonnementToggle);
    }
    private void createAttributes(){
        Label nomLabel = new Label("Nom de famille :");
        nomField = new TextField();
        Label prenomLabel = new Label("Prenom :");
        prenomField = new TextField();
        Label courrielLabel = new Label("Courriel :");
        courrielField = new TextField();
        Label telephoneLabel = new Label("Numero de telephone :");
        telephoneField = new TextField();
        Label adresseLabel = new Label("Adresse :");
        adresseField = new TextField();
        Label ccTypeLabel = new Label("Type (VISA/MasterCard/Amex) :");
        ccTypeField = new TextField();
        Label ccNumberLabel = new Label("Numero :");
        ccNumberField = new TextField();
        Label ccExpirationLabel = new Label("Date expiration (mois/annee) :");
        ccExpirationField = new TextField();
        Label ccCvvLabel = new Label("CVV :");
        ccCvvField = new TextField();
        Label dateNaissanceLabel = new Label("Date de naissance :");
        dateNaissanceField = new TextField();
        Label motDePasseLabel = new Label("Mot de passe :");
        motDePasseField = new PasswordField();
        payerButton = new Button("Payer");

        // Ajout des noeuds au GridPane
        add(debutantButton, 0, 0);
        add(intermediaireButton, 1, 0);
        add(avanceButton, 2, 0);
        add(nomLabel, 0, 1);
        add(nomField, 1, 1);
        add(prenomLabel, 0, 2);
        add(prenomField, 1, 2);
        add(courrielLabel, 0, 3);
        add(courrielField, 1, 3);
        add(telephoneLabel, 0, 4);
        add(telephoneField, 1, 4);
        add(adresseLabel, 0, 5);
        add(adresseField, 1, 5);
        add(ccTypeLabel, 0, 6);
        add(ccTypeField, 1, 6);
        add(ccNumberLabel, 0, 7);
        add(ccNumberField, 1, 7);
        add(ccExpirationLabel, 0, 8);
        add(ccExpirationField, 1, 8);
        add(ccCvvLabel,0,9);
        add(ccCvvField,1,9);
        add(dateNaissanceLabel,0,10);
        add(dateNaissanceField,1,10);
        add(motDePasseLabel,0,11);
        add(motDePasseField,1,11);
        add(payerButton,1,15);
    }

    public RadioButton getDebutantButton(){
        return debutantButton;
    }

    public RadioButton getIntermediaireButton(){
        return intermediaireButton;
    }

    public RadioButton getAvanceButton(){
        return avanceButton;
    }

    public Button getPayerButton(){
        return payerButton;
    }

}
