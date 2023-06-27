package com.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class AbonnementController {

    private AbonnementUI abonnementUI;

    public AbonnementController(AbonnementUI abonnementUI){

        this.abonnementUI = abonnementUI;
        abonnementUI.getPayerButton().setOnAction(new PayerButtonHandler());
    }

    class PayerButtonHandler implements EventHandler<ActionEvent> {

        //TO-DO : IMPLEMENTER/VERIFIER DANS LA DB
        @Override
        public void handle(ActionEvent actionEvent) {
            //Message pour dire que l'abonnement a ete fait
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setHeaderText("Payement effectué");
            successAlert.setContentText("L'abonnement a été faite avec succès!");
            successAlert.showAndWait();
        }
    }
}
