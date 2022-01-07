module com.example.newrecord {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.newrecord to javafx.fxml;
    exports com.example.newrecord;
}