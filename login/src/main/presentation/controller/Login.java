package main.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import main.application.App;

import java.net.URL;
import java.util.ResourceBundle;


public class Login implements Initializable {

   @FXML
   private  TextField userField;

   @FXML
   private TextField pwField;

   @FXML
   private Button loginButton;

   @FXML
   private VBox root;

    @FXML
    private void quit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label error = new Label();
        root.getChildren().add(error);
        loginButton.setOnAction( e-> {
            if ("pw".equals(pwField.getText())) {
                if("user".equals(userField.getText())){
                    App.getInstance().loadWindow("/fxml/Main.fxml","Person");
                }else error.setText("Username wrong");
            }else error.setText("Password wrong");

        });
    }
}
