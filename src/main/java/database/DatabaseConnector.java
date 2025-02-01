package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    static private final String JDBC_URL = "jdbc:postgresql://localhost:5432/olx_pirata";
    static private final String USER = "postgres";
    static private final String PASSWORD = "1281";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
}
