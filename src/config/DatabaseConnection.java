package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                AppConfig.get("db.url"),
                AppConfig.get("db.username"),
                AppConfig.get("db.password")
        );
    }
    public static boolean isConnected() {
        try(Connection conn = getConnection()){
            return conn.isValid(2);
        } catch (SQLException e){
            return false;
        }
    }
}
