import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnector {
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/olx_pirata";

    protected static Connection connect() {
        try(Connection connection = DriverManager.getConnection(JDBC_URL)) {
            return connection;
//            String query = """
//                CREATE TABLE users(
//                    id SERIAL PRIMARY KEY,
//                    email VARCHAR(255)
//                );
//                """;
//
//            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
