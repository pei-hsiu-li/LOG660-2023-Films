package com.gui;

/**
 * Controller qui gere le bouton s'abonner dans ForfaitUI et nous amene a la page AbonnementUI
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ForfaitController {

    private ForfaitsUI forfaitsUI;
    private AbonnementUI abonnementUI;

    public ForfaitController(ForfaitsUI forfaitsUI, AbonnementUI abonnementUI){
        this.forfaitsUI = forfaitsUI;
        this.abonnementUI = abonnementUI;
        forfaitsUI.getAbonnementButton().setOnAction(new AbonnementButtonHandler());

    }

    class AbonnementButtonHandler implements EventHandler<ActionEvent> {

        //Pas besoin de queries ici car ca nous amene a la page AbonnementUI
        @Override
        public void handle(ActionEvent e) {
            Main.changeScene(new Scene(abonnementUI,700,700));
        }
    }
}
