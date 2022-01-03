package com.example.hello1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MenuController implements Initializable{
    @FXML public Button btnAdd;


    @FXML public TextField textToDo;

    @FXML public TableView<Tasks> tableView;

    @FXML public TableColumn<Tasks, String> taskId;

    @FXML public TableColumn<Tasks, String >task;

    @FXML public TableColumn<Tasks, String> taskDate;

    @FXML public Button btnRemove;

    @FXML public DatePicker date;

    private int currentId = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskId.setCellValueFactory(new PropertyValueFactory<Tasks, String>("taskId"));
        task.setCellValueFactory(new PropertyValueFactory<Tasks, String>("task"));
        taskDate.setCellValueFactory(new PropertyValueFactory<Tasks, String>("taskDate"));
        tableView.getItems().setAll(DatabaseHandler.init());
    }

    public void addNewTask(ActionEvent actionEvent) {
        DatabaseHandler.addTask(new Tasks(Integer.toString(0), textToDo.getText(), date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        tableView.getItems().setAll(DatabaseHandler.init());
    }

    public void removeTask(ActionEvent actionEvent) {
        if (currentId != -1) {
            DatabaseHandler.deleteTask(currentId);
            tableView.getItems().setAll(DatabaseHandler.init());
        }
    }
    public void clickItem(MouseEvent event){
        if(event.getClickCount() == 1){
            System.out.println(tableView.getSelectionModel().getSelectedItem().getTaskId());
            currentId = Integer.parseInt(tableView.getSelectionModel().getSelectedItem().getTaskId());
        }
    }
}
