package main.java.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.application.App;
import main.java.application.service.LoginService;
import main.java.bdo.User;

import java.net.URL;
import java.util.ResourceBundle;


public class Login implements Initializable {

    @FXML
    private PasswordField pw;
    @FXML
    private TextField username;

    private LoginService loginService;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginService = LoginService.getInstance();
        user = User.getInstance();
    }

    @FXML
    void cancel(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void login(ActionEvent event) {
        pw.setStyle("-fx-border-color: yellow;");
        username.setStyle("-fx-border-color: yellow;");

        user.setData(username.getText(), pw.getText());

        if (!loginService.userLogin(user)) {
            pw.setStyle("-fx-border-color: red;");
            username.setStyle("-fx-border-color: red;");
        } else
            App.getInstance().openWindow("Main", "/fxml/main.fxml", true);
    }
}
