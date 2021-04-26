package main.java.application.service;

import main.java.bdo.Employee;
import main.java.data.dao.EmployeeDAO;
import main.java.data.daoImpl.EmployeeDAOImpl;

import java.util.List;


public class EmployeeService {

    private static EmployeeService instance;
    private EmployeeDAO employeeDAO;

    private EmployeeService() {
        employeeDAO = new EmployeeDAOImpl();
    }

    public static EmployeeService getInstance() {
        if (instance == null)
            instance = new EmployeeService();
        return instance;
    }

    public List<Employee> searchByName(String name) {
        return (name == null || name.isBlank()) ? employeeDAO.getAllEmployees() : employeeDAO.searchByName(name);
    }
}
