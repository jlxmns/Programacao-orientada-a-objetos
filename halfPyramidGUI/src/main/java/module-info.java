module com.example.invertedpyramidgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.invertedpyramidgui to javafx.fxml;
    exports com.example.invertedpyramidgui;
}