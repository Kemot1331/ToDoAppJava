package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://192.168.1.100:3306/ToDoApp";
    private static final String USER = "root";
    private static final String PASSWORD = "baza123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static boolean isConnected() {
        try(Connection conn = getConnection()){
            return conn.isValid(2);
        } catch (SQLException e){
            return false;
        }
    }
}
