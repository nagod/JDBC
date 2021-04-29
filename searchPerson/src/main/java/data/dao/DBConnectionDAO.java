package main.java.data.dao;

import main.java.bdo.User;

import java.sql.Connection;
import java.sql.SQLException;



public interface DBConnectionDAO {
    Connection openConnection(User user) throws SQLException;
    Connection getConnection();
    void closeConnection();
}
