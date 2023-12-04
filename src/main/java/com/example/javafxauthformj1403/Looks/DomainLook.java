package com.example.javafxauthformj1403.Looks;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DomainLook extends Stage {

    public void init() throws IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DomainLook.fxml"));

        Scene scene = new Scene(root);
        setTitle("Domain");
        setScene(scene);
        setResizable(false);
        show();
    }

}