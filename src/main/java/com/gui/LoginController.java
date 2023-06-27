package com.gui;

import com.hibernate.ClientEntity;
import com.hibernate.HibernateUtil;
import com.hibernate.PersonneEntity;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import org.hibernate.Session;

import java.math.BigInteger;
import java.util.List;

import static com.test.disableLogging;

/**
 * Controller qui va changer de scene de LoginUI a tache 1 ou 2
 */

public class LoginController {
    private LoginUI_Lab4 loginUI;
    private RechercheUI rechercheUI;

    Scene tache1Scene = new Scene(new Tache1_UI(),600,400);

    public LoginController(LoginUI_Lab4 loginUI, RechercheUI rechercheUI) {
        this.loginUI = loginUI;
        this.rechercheUI = rechercheUI;
        loginUI.getLoginButton().setOnAction(new LoginButtonHandler());

        loginUI.usernameTextField.setText("JoABowers24@gmail.com");
        loginUI.passwordField.setText("Eidaith3");
    }

    private List<PersonneEntity> rechercheUser(String usernamme, String password){
        disableLogging();

        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        String hql = "FROM PersonneEntity WHERE courriel LIKE '" + usernamme + "' AND  motdepasse LIKE '" + password +"'";
        List<PersonneEntity> personne =  ss.createQuery(hql).list();

        ss.getTransaction().commit();
        ss.close();
        return personne;
    }

    private BigInteger clientID(BigInteger personneId){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        String hql = "FROM ClientEntity WHERE idpersonne LIKE '" + personneId + "'";
        ClientEntity client =  (ClientEntity) ss.createQuery(hql).getSingleResult();

        ss.getTransaction().commit();
        ss.close();
        return client.getIdclient();
    }



    class LoginButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            List<PersonneEntity> personne = rechercheUser(loginUI.usernameTextField.getText(), loginUI.passwordField.getText());

            if(personne.size() >0 ) {
                PersonneEntity p = personne.get(0);
                Auth auth = Auth.getInstance();
                auth.setAuthUserId(clientID(p.getIdpersonne()));

                if (loginUI.getTache1_button().isSelected()) {
                    // Si le bouton de la tache 1 est sélectionné, changer de scène vers Tache1_UI
                    Main.changeScene(tache1Scene);

                } else if(loginUI.getTache2_button().isSelected()){
                    // Si le bouton de la tache 2 est sélectionné, changer de scène vers la Recherche de film
                    Main.changeScene(new Scene(rechercheUI,600,600));
                }

            }
            else if (personne.size() == 0) {
                loginUI.usernameTextField.clear();
                loginUI.passwordField.clear();
                loginUI.noUser.setAlertType(Alert.AlertType.ERROR);
                loginUI.noUser.setContentText("Aucun utilisateur trouvé");
                loginUI.noUser.show();
            }



        }
    }

}
