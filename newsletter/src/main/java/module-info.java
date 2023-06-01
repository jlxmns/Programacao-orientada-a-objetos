module com.example.newsletter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.newsletter to javafx.fxml;
    exports com.example.newsletter;
}