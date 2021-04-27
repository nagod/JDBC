package main.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.application.App;
import main.application.service.PersonService;
import main.bdo.Person;


import java.net.URL;
import java.util.ResourceBundle;

public class Edit implements Initializable {

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
    private VBox root;

    // TODO function für emty check schreiben
    @FXML
    void addPerson(ActionEvent event) {
        String first_name = first_name_textfield.getText();
        String last_name = last_name_textfield.getText();
        String city = city_textfield.getText();
        String favorite_color = favorite_color_texfield.getText();
        if (first_name.isEmpty())  first_name_label.setTextFill(Color.web("#ff0000"));
        if (last_name.isEmpty())last_name_label.setTextFill(Color.web("#ff0000"));
        if(city.isEmpty()) city_label.setTextFill(Color.web("#ff0000"));
        if(favorite_color.isEmpty()) favorite_color_label.setTextFill(Color.web("#ff0000"));
        else {
            PersonService.getInstance().createPerson(first_name,last_name,city,favorite_color);
            close();
        }
    }

    @FXML
    void deletePerson(ActionEvent event) {
        String first_name = first_name_textfield.getText();
        String last_name = last_name_textfield.getText();
        String city = city_textfield.getText();
        String favorite_color = favorite_color_texfield.getText();
        Person tmp = new Person(first_name,last_name,city,favorite_color);
        PersonService.getInstance().delete(tmp);
        close();
    }
    @FXML
    void close(){
        App.getInstance().loadWindow("/fxml/Main.fxml","Main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
