package main.java.data.dao;

import main.java.bdo.Employee;

import java.util.List;



public interface EmployeeDAO {
    List<Employee> searchByName(String name);
    List<Employee> getAllEmployees();
}
