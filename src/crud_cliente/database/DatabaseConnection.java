package crud_cliente.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CRUD_CLIENTE;integratedSecurity=true;";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "wad";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = java.sql.DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return connection;
    }

    public static void closeDatabaseConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
