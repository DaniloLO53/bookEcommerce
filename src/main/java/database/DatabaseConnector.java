package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/olx_pirata";
    static final String user = "postgres";
    static final String password = "1281";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, user, password);
    }
}
