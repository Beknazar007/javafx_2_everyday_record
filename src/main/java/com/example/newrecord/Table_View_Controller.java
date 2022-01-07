package com.example.newrecord;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Table_View_Controller implements Initializable {

    @FXML public TableView<Table_View_Modules> table;

    @FXML public TableColumn<Table_View_Modules, String> name_id;
    @FXML public TableColumn<Table_View_Modules, String> surname_id;
    @FXML public TableColumn<Table_View_Modules, String> wishes_id;
    @FXML public TableColumn<Table_View_Modules, String> date_id;

    ObservableList<Table_View_Modules> Timelist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location , ResourceBundle resources){

        Connection con = null;

        try {
            con = DatabaseHandler.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM wish ");
            while (rs.next()){
                Timelist.add(new Table_View_Modules(
                        rs.getString("name"),rs.getString("surname"),
                        rs.getString("wishes"),rs.getString("recDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        name_id.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname_id.setCellValueFactory(new PropertyValueFactory<>("surname"));
        wishes_id.setCellValueFactory(new PropertyValueFactory<>("wishes"));
        date_id.setCellValueFactory(new PropertyValueFactory<>("recDate"));
        table.setItems(Timelist);

    }

}
