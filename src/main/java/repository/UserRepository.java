package repository;

import database.DatabaseConnection;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> findByName(String name) {
        String query = "SELECT * FROM users WHERE CONCAT(first_name, last_name) ILIKE ?";
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, "%" + name + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = buildUserByResultSet(resultSet);
                    users.add(user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static List<User> findAll() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                User user = buildUserByResultSet(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static User buildUserByResultSet(ResultSet resultSet) throws SQLException {
        return User
                .builder()
                .id(resultSet.getInt("id"))
                .email((resultSet.getString("email")))
                .firstName((resultSet.getString("first_name")))
                .lastName((resultSet.getString("last_name")))
                .password((resultSet.getString("password")))
                .build();
    }
}
