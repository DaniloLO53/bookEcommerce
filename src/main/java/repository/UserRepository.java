package repository;

import database.DatabaseConnector;
import domain.User;

import java.sql.*;

public class UserRepository {
    public static void save(User user) {
        String query = """
                    INSERT INTO users(email, first_name, last_name, password)
                    VALUES
                    (?, ?, ?, ?);
                    """;

        try(Connection conn = DatabaseConnector.connect()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        try(Connection conn = DatabaseConnector.connect()) {
            String query = """
                    SELECT * from users;
                    """;

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
