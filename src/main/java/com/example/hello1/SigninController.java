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
import java.sql.ResultSet;
import java.sql.SQLException;

public class SigninController {
    @FXML private TextField login;

    @FXML private PasswordField password;

    @FXML private Button SigninButton;

    @FXML private Button SignUpButton;

    @FXML void initialize(){

        SigninButton.setOnAction(actionEvent -> {
            String loginText = login.getText().trim();
            String loginPassword = password.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Something went wrong");
                alert.showAndWait();
                System.out.println("Login and password is empty");
            }

        });





        SignUpButton.setOnAction(actionEvent -> {
            openNewScene("SignUp.fxml");
        });
    }
    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int count = 0;
        try {
            while (result.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (count >= 1){
            openNewScene("user_time.fxml");
        }else {
            Shake userLoginAnim = new Shake(login);
            Shake userPassAnim = new Shake(password);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
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

