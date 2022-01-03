package com.example.hello1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SigninController {
    @FXML private TextField NumOfTable;

    @FXML private PasswordField NameOfClient;

    @FXML private Button SigninButton;

    @FXML private Button SignUpButton;

    @FXML void initialize(){

        SigninButton.setOnAction(actionEvent -> {
            openNewScene("menu.fxml");
        });





        SignUpButton.setOnAction(actionEvent -> {
            openNewScene("Signup.fxml");
        });
    }


    public void openNewScene(String window){
        SignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

