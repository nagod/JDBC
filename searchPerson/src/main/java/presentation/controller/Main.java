package main.java.presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.application.service.EmployeeService;
import main.java.bdo.Employee;

import java.net.URL;
import java.util.ResourceBundle;


public class Main implements Initializable {
    @FXML
    private TextField search;
    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> colFirstName, colLastName, colMail;
    @FXML
    private TableColumn<Employee, Integer> colId, colSalary;

    private ObservableList<Employee> employeesObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(employeesObservable);

        colFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));
        colFirstName.setStyle("-fx-font-family: 'Al Bayan'");

        colLastName.setCellValueFactory(new PropertyValueFactory("lastName"));
        colLastName.setStyle("-fx-font-family: 'Al Bayan'");

        colMail.setCellValueFactory(new PropertyValueFactory("mail"));
        colMail.setStyle("-fx-font-family: 'Al Bayan'");


        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setStyle("-fx-font-family: 'Al Bayan'");


        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colSalary.setStyle("-fx-font-family: 'Al Bayan'");

    }

    @FXML
    private void search(ActionEvent actionEvent) {
        employeesObservable.clear();
        employeesObservable.addAll(EmployeeService.getInstance().searchByName(search.getText()));
    }
}
