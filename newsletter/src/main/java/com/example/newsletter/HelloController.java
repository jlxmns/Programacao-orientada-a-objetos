package com.example.newsletter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //Screens:
    @FXML private VBox insertScreen;
    @FXML private VBox showScreen;

    //Tables
    @FXML private TableView<Reader> tableView;
    @FXML private TableColumn<Reader, String> idColumn;
    @FXML private TableColumn<Reader, String> nameColumn;
    @FXML private TableColumn<Reader, String> emailColumn;
    @FXML private TableColumn<Reader, String> birthColumn;

    //Setting Table Infos:


    //Info Getters:
    @FXML private TextField nameTField;
    @FXML private TextField emailTField;
    @FXML private DatePicker birthDatePicker;


    //Screen Control Functions:
    @FXML void onButtonInsertMainScreenClick() {
        insertScreen.setVisible(true);
    }

    @FXML void onButtonShowMainScreenClick() {
        showScreen.setVisible(true);
    }

    @FXML void onButtonBackClick() {
        insertScreen.setVisible(false);
        showScreen.setVisible(false);
    }

    //Add New Reader Function:

    @FXML void addNewReader() {
        String name = nameTField.getText();
        String email = emailTField.getText();
        LocalDate birthday = birthDatePicker.getValue();

        Reader r = new Reader(name, email, birthday);

        //Persistência do dado:
        DBConnect newsletterDB = new DBConnect();
        JDBCReader manager = new JDBCReader(newsletterDB.startConnection());
        manager.addReader(r);
        newsletterDB.endConnection();

        nameTField.setText("");
        emailTField.setText("");
        birthDatePicker.setValue(null);
        nameTField.requestFocus();
    }

    //List All Readers Function:

    @FXML void listAllReaders() {
        tableView.getItems().clear();
        DBConnect newsletterDB = new DBConnect();
        JDBCReader manager = new JDBCReader(newsletterDB.startConnection());
        ObservableList<Reader> readers = manager.listReaders();
        tableView.setItems(readers);
    }

    @FXML void eraseAllReaders() {
        DBConnect newsletterDB = new DBConnect();
        JDBCReader manager = new JDBCReader(newsletterDB.startConnection());
        manager.deleteEverything();
        newsletterDB.endConnection();

        tableView.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
    }
}