package main.java.application.service;

import main.java.bdo.User;
import main.java.data.dao.DBConnectionDAO;
import main.java.data.daoImpl.DBConnectionDAOImpl;

import java.sql.SQLException;


public class LoginService {

    private static LoginService instance;
    private DBConnectionDAO dbConnection;

    private LoginService() {

    }

    public static LoginService getInstance() {
        if (instance == null)
            instance = new LoginService();
        return instance;
    }

    public boolean userLogin(User user) {
        dbConnection = DBConnectionDAOImpl.getInstance();

        if (user.getUsername() == null || user.getPassword() == null || user.getUsername().isBlank() || user.getPassword().isBlank())
            return false;

        try {
            dbConnection.openConnection(user);
            return dbConnection.getConnection() != null && dbConnection.getConnection().isValid(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void userLogout() {
        try {
            if (dbConnection.getConnection().isClosed() && dbConnection.getConnection().isValid(0))
                dbConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
