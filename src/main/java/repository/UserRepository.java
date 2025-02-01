package repository;

import database.DatabaseConnector;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> findByEmail(String email)  {
        String query = "SELECT * FROM users WHERE email = ?";
        List<User> users = new ArrayList<>();

        try(Connection connection = DatabaseConnector.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, email);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = User.builder()
                            .email(resultSet.getString("email"))
                            .firstName(resultSet.getString("first_name"))
                            .lastName(resultSet.getString("last_name"))
                            .password(resultSet.getString("password"))
                            .build();
                    users.add(user);
                }

                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet save(User user) throws SQLException {
        String query = """
                INSERT INTO users(email, first_name, last_name, password)
                VALUES
                (?, ?, ?, ?);
                """;

        Connection conn = DatabaseConnector.connect();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getPassword());
        return preparedStatement.executeQuery();
    }
}
