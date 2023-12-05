package com.example.javafxauthformj1403;
import com.example.javafxauthformj1403.DBConnect.UserRepImpl;
import com.example.javafxauthformj1403.Looks.PersonLook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppController implements Initializable {

    @FXML
    private Button buttonSignIn;
    @FXML
    private TextField textName;
    @FXML
    private TextField textPassword;
    @FXML
    private Label textLabel;

   public AppController(){

    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
       UserRepImpl userRep = new UserRepImpl();
       PersonLook pl = new PersonLook();
        if (event.getSource().equals(buttonSignIn)) {
            userRep.getUsers().forEach(e -> {
                if (textName.getText().equals(e.getName()) && textPassword.getText().equals(e.getPassword())) {
                    textLabel.setText("connected");
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.hide();
                    try {
                        pl.init();
                    } catch (IOException ex) {
                        Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    textLabel.setText("NOT connected");
                }
            });
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}

