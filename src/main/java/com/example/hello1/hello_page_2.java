package com.example.hello1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class hello_page_2 {

    @FXML
    private Label welcomeText;
    @FXML
    private Label welcomeText2;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

    }
    @FXML

    protected void onHelloButtonClick2() {

        welcomeText2.setText("Welcome Beki");
    }
}
