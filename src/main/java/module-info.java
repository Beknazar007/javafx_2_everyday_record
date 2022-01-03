module com.example.hello1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hello1 to javafx.fxml;
    exports com.example.hello1;
}