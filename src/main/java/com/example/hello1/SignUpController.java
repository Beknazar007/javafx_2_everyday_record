package com.example.hello1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    @FXML

    public TextField user_name;
    @FXML
    private TextField user_LastName;
    @FXML
    private TextField user_login;
    @FXML
    private PasswordField user_card;
    @FXML
    private PasswordField user_password;
    @FXML
    private RadioButton user_gender;
    @FXML
    private Button signUpButton;
    @FXML
    private Button Back_to_Signin;

    @FXML
    void initialize() {
        Back_to_Signin.setOnAction(actionEvent -> {
            openAuthPage("Signin.fxml");
        });

        signUpButton.setOnAction(actionEvent -> {
            String loginText = user_login.getText().trim();
            String loginPassword = user_password.getText().trim();
            if (!loginText.equals("")&& !loginPassword.equals("")){
                signUpNewUser();
                openAuthPage("menu.fxml");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Замечание");
                alert.setHeaderText(null);
                alert.setContentText("Логин и пароль пустые");
                alert.showAndWait();
                System.out.println("Login and password is empty");
            }
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = user_name.getText();
        String lastName = user_LastName.getText();
        String userName = user_login.getText();
        String password = user_password.getText();
        String card     = user_card.getText();
        String gender;
        if (user_gender.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName,lastName,userName,password,gender,card);

        dbHandler.addNewUser(user);
    }

    private void openAuthPage(String window){
        signUpButton.getScene().getWindow().hide();

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