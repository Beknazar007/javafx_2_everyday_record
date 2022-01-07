package com.example.newrecord;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import java.time.format.DateTimeFormatter;

public class Wishes_Controller {

    @FXML public TextField add_name;
    @FXML public TextField add_surname;
    @FXML public TextArea add_wishes;
    @FXML public DatePicker add_date;

    @FXML public Button btnAdd;
    @FXML public Button AddWishes;

    @FXML private Button SignInButton;

    @FXML
    void initialize (){
        SignInButton.setOnAction(actionEvent -> {
            openAuthPage("table.fxml");
        });
    }
    @FXML
    public void AddNewWishes() {

        DatabaseHandler databaseHandler = new DatabaseHandler();

        String name = add_name.getText();
        String surname = add_surname.getText();
        String wishes  = add_wishes.getText();
        String recdate = add_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Wishes_Module_class userWish = new Wishes_Module_class(name,surname,wishes,recdate);

        databaseHandler.addNewUserWishes(userWish);
    }





    public void openAuthPage(String window){
        SignInButton.getScene().getWindow().hide();
        System.out.println("Table view");

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
