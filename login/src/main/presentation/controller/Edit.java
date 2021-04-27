package main.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.application.App;


import java.net.URL;
import java.util.ResourceBundle;

public class Edit  implements Initializable {

    @FXML
    private Label first_name_label;

    @FXML
    private TextField first_name_textfield;

    @FXML
    private Label last_name_label;

    @FXML
    private TextField last_name_textfield;

    @FXML
    private Label city_label;

    @FXML
    private TextField city_textfield;

    @FXML
    private Label favorite_color_label;

    @FXML
    private TextField favorite_color_texfield;

    @FXML
    void addPerson(ActionEvent event) {

    }

    @FXML
    void deletePerson(ActionEvent event) {

    }
    @FXML
    void close(){
        App.getInstance().loadWindow("fxml/Main","Main");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
