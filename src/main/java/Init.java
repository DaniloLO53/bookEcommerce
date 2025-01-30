import java.sql.Connection;

public class Init {
    public static void main(String[] args) {
        Connection connection = DatabaseConnector.connect();
    }
}
