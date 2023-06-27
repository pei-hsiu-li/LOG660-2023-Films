package com.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launch class (main)
 */

public class Main extends Application {
    private static Stage stage;
    private LoginUI_Lab4 loginUI;
    private static RechercheUI rechercheUI;
    private static FilmDescriptionUI filmDescriptionUI;
    private Tache1_UI tache1_ui;

    /**
     * Methode pour lancer la premiere scene (Login)
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        //Creation des scenes et controllers
        createInterfaces();
        createControllers();

        //On lance la premiere scene LoginUI
        Scene scene = new Scene(loginUI, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Methode qui permet de changer de scene, on l'appel dans les controller class
     */
    public static void changeScene(Scene scene) {
        stage.setScene(scene);
    }
    public static void restartTache() {
        LoginUI_Lab4 newLoginUI_lab4 = new LoginUI_Lab4();
        LoginController newLoginController = new LoginController(newLoginUI_lab4, rechercheUI);
        Scene scene = new Scene(newLoginUI_lab4, 600, 400);
        stage.setScene(scene);
    }

    /**
     * Methodes pour creer les controllers et interfaces
     */
    private void createControllers(){
        LoginController loginController = new LoginController(loginUI, rechercheUI);
        RechercheController rechercheController = new RechercheController(rechercheUI,filmDescriptionUI);
    }

    private void createInterfaces(){
        loginUI = new LoginUI_Lab4();
        rechercheUI = new RechercheUI();
        filmDescriptionUI = new FilmDescriptionUI();
        tache1_ui = new Tache1_UI();
    }

    /**
     * Main method pour launch l'interface
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
