package main.java.data.daoImpl;

import main.java.bdo.User;
import main.java.data.dao.DBConnectionDAO;
import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionDAOImpl implements DBConnectionDAO {

    private static DBConnectionDAOImpl instance;
    private Connection connection;

    private DBConnectionDAOImpl() {

    }

    public static DBConnectionDAOImpl getInstance() {
        if (instance == null)
            instance = new DBConnectionDAOImpl();
        return instance;
    }

    // jdbc:oracle:thin:@dbvm02.iai.uni-bonn.de:1521/reldb (VPN)
    // jdbc:oracle:thin:@localhost:1521/reldb (SSH)

    @Override
    public Connection openConnection(User user) {
        try {
           Driver myDriver = new OracleDriver();
           DriverManager.registerDriver( myDriver );
           String url = "jdbc:oracle:thin:@localhost:1521/reldb";
           connection = DriverManager.getConnection(url, user.getUsername(), user.getPassword());
           System.out.println("Connected !");
        }
        catch(SQLException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        return connection;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close the connection " + e);
        }
    }
}
