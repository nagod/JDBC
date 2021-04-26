package main.java.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class App extends Application {

    private static App instance;
    private Stage primaryStage;

    public static App getInstance() {
        return instance;
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));

        instance = this;
        primaryStage = stage;
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }

    public void openWindow(String title, String url, boolean resizable) {
        try {
            primaryStage.hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));

            primaryStage.setResizable(resizable);
            primaryStage.setTitle(title);
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.exit(0);
    }
}
