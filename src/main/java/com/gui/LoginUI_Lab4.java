package com.gui;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * UI POUR SE LOGIN (PAGE 1)
 */

public class LoginUI_Lab4 extends GridPane {

    private Label usernameLabel;
    private Label passwordLabel;
    public TextField usernameTextField;
    public PasswordField passwordField;


    // create a alert
    Alert noUser = new Alert(Alert.AlertType.NONE);
    private Button loginButton;
    private Label tache1_label;
    private Label tache2_label;
    private RadioButton tache1_button;
    private RadioButton tache2_button;

    public LoginUI_Lab4() {
        createAttributes();
        setGridPane();
        addAttributes();
    }

    private void createAttributes() {

        usernameLabel = new Label("Username:");
        usernameTextField = new TextField();
        passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        tache1_label = new Label("Tache 1");
        tache1_button = new RadioButton();

        tache2_label = new Label("Tache 2");
        tache2_button = new RadioButton();

        //Pour empecher de selectionner les 2 boutons en meme temps
        ToggleGroup toggleGroup = new ToggleGroup();
        tache1_button.setToggleGroup(toggleGroup);
        tache2_button.setToggleGroup(toggleGroup);

        loginButton = new Button("Executer tache");
    }

    private void setGridPane() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
    }

    private void addAttributes() {

        add(usernameLabel, 0, 1);
        add(usernameTextField, 1, 1);
        add(passwordLabel, 0, 2);
        add(passwordField, 1, 2);
        add(tache1_label, 0, 3);
        add(tache1_button, 1, 3);
        add(tache2_label, 0, 4);
        add(tache2_button, 1, 4);
        add(loginButton, 1, 5);
    }

    public Button getLoginButton(){
        return loginButton;
    }

    public RadioButton getTache1_button(){
        return tache1_button;
    }

    public RadioButton getTache2_button(){
        return tache2_button;
    }
}
