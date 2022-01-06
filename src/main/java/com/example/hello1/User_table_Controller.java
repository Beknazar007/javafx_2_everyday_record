package com.example.hello1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class User_table_Controller implements Initializable{

    @FXML public TextField coming;
    @FXML public TextField leaving;
    @FXML public TextField studying;
    @FXML public DatePicker date;
    @FXML public TableView<User_time> tableView;
    @FXML public TableColumn<User_time, String> userId;
    @FXML public TableColumn<User_time, String> coming_v;
    @FXML public TableColumn<User_time, String > leaving_v ;
    @FXML public TableColumn<User_time, String> studying_v;
    @FXML public TableColumn<User_time, String> recDate;
    @FXML public Button btnAdd;
    @FXML public Button btnRemove;

    @FXML private Button SignInButton;

    private int currentId = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userId.setCellValueFactory(new PropertyValueFactory<User_time, String>("userId"));
        coming_v.setCellValueFactory(new PropertyValueFactory<User_time, String>("coming"));
        leaving_v.setCellValueFactory(new PropertyValueFactory<User_time, String>("leaving"));
        studying_v.setCellValueFactory(new PropertyValueFactory<User_time, String>("studying"));
        recDate.setCellValueFactory(new PropertyValueFactory<User_time, String>("recDate"));
        tableView.getItems().setAll(DatabaseHandler.init());

    }
    public void addUsersTime(ActionEvent actionEvent) {
        DatabaseHandler.addNewTime(new User_time(Integer.toString(0), coming.getText() ,leaving.getText(), studying.getText(), date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        tableView.getItems().setAll(DatabaseHandler.init());
    }

    public void removeTimeRec(ActionEvent actionEvent) {
        if (currentId != -1) {
            DatabaseHandler.deleteTask(currentId);
            tableView.getItems().setAll(DatabaseHandler.init());
        }
    }

    public void clickItem(MouseEvent event){
        if(event.getClickCount() == 1){
            System.out.println(tableView.getSelectionModel().getSelectedItem().getUserId());
            currentId = Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getUserId());
        }
    }
    @FXML
    void initialize() {
        SignInButton.setOnAction(actionEvent -> {
            openAuthPage("Signin.fxml");
        });
    }
    private void openAuthPage(String window){
        SignInButton.getScene().getWindow().hide();

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
