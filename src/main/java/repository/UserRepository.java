package repository;

import database.DatabaseConnection;
import domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> findAll() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {

            while (resultSet.next()) {
                User user = User
                        .builder()
                        .id(resultSet.getInt("id"))
                        .email((resultSet.getString("email")))
                        .firstName((resultSet.getString("first_name")))
                        .lastName((resultSet.getString("last_name")))
                        .password((resultSet.getString("password")))
                        .build();
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
