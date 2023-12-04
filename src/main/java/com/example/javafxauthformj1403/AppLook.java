package com.example.javafxauthformj1403;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLook extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("AppLook.fxml"));
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("JavaFX Welcome");
            stage.setResizable(false);
            stage.show();
        }

    public static void main(String[] args) {
        launch();
    }
}