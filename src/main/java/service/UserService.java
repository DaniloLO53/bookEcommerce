package service;

import domain.User;
import repository.UserRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {
    public static List<User> findByEmail(String email) {
        List<User> users = UserRepository.findByEmail(email);

        if (users == null) {
            throw new RuntimeException("No users found.");
        }

        return users;
    }

    public static void save(User user) {
        try (ResultSet resultSet = UserRepository.save(user)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
