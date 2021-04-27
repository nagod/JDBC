package main.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.application.App;
import main.application.service.PersonService;
import main.bdo.Person;
import main.data.dao.PersonDAO;

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

    private static ObservableList<Person> personObservableList = FXCollections.observableArrayList(
            //new Person("Rüdiger","Räuber","Aachen","lila"),
           // new Person("Achim","Knecht","Bonn","rosa"),
           // new Person("1","1","1","1")
    );



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // load items if given
        personObservableList.clear();
        personObservableList.addAll(PersonService.getInstance().getAll());
        tableView.setItems(personObservableList);

        // init columns
        fist_name_col.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_name_col.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        city_col.setCellValueFactory(new PropertyValueFactory<>("city"));
        favorite_color_col.setCellValueFactory(new PropertyValueFactory<>("favorite_color"));
    }

    @FXML
    void edit_button(ActionEvent event) {
        App.getInstance().loadWindow("/fxml/Edit.fxml","Edit");
    }

    public void quit(ActionEvent event) {
        System.exit(1);
    }
}
