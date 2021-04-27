package main.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.application.App;
import main.bdo.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String > fist_name_col;

    @FXML
    private TableColumn<Person, String > last_name_col;

    @FXML
    private TableColumn<Person, String > city_col;

    @FXML
    private TableColumn<Person, String > favorite_color_col;

    // TODO Sinn verstehen
    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // load items if given
        tableView.setItems(personObservableList);

        // init columns
        fist_name_col.setCellFactory(new PropertyValueFactory("fist_name"));
        last_name_col.setCellFactory(new PropertyValueFactory("last_name"));
        city_col.setCellFactory(new PropertyValueFactory("city"));
        favorite_color_col.setCellFactory(new PropertyValueFactory("favorite_color"));
    }

    @FXML
    void edit_button(ActionEvent event) {
        App.getInstance().loadWindow("/fxml/Edit","Edit");
    }

}
