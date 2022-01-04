package com.example.hello1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private PasswordField user_password;

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
                openAuthPage("Signin.fxml");
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





    @FXML
    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        String lastName = user_LastName.getText();
        String firstName = user_name.getText();
        String userName = user_login.getText();
        String password = user_password.getText();

        User user = new User(firstName,lastName,userName,password);

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