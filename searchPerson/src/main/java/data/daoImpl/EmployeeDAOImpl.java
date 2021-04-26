package main.java.data.daoImpl;

import main.java.bdo.Employee;
import main.java.data.dao.EmployeeDAO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDAOImpl implements EmployeeDAO {
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public List<Employee> searchByName(String name) {
        String query = "SELECT * FROM HR.employees WHERE LOWER(employees.first_name) = ? OR LOWER(employees.last_name) = ? ";
        Connection connection = DBConnectionDAOImpl.getInstance().getConnection();
        try{
            employeeList.clear();
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1,name);
            stm.setString(2,name);
            ResultSet res = stm.executeQuery();
            while(res.next()){
                java.math.BigDecimal id = (BigDecimal) res.getObject("employee_id");
                java.lang.String first_name = res.getString("first_name");
                java.lang.String last_name = res.getString("last_name");
                java.lang.String mail = res.getString("email");
                java.math.BigDecimal salary = (BigDecimal) res.getObject("salary");
                Employee e = new Employee(first_name,last_name, mail, id.intValue(), salary.intValue());
                employeeList.add(e);
            }
            res.close();
            stm.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM HR.employees";
        Connection connection = DBConnectionDAOImpl.getInstance().getConnection();

        try{
            employeeList.clear();
            Statement stm = connection.createStatement();
            ResultSet res = stm.executeQuery(query);
            while(res.next()){
                java.math.BigDecimal id = (BigDecimal) res.getObject("employee_id");
                java.lang.String first_name = res.getString("first_name");
                java.lang.String last_name = res.getString("last_name");
                java.lang.String mail = res.getString("email");
                java.math.BigDecimal salary = (BigDecimal) res.getObject("salary");
                Employee e = new Employee(first_name,last_name, mail, id.intValue(), salary.intValue());
                employeeList.add(e);
            }
            res.close();
            stm.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }
}
