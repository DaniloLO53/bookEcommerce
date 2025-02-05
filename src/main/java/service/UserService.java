package service;

import domain.User;
import httpServer.HttpStatusCode;
import httpServer.errors.HttpException;
import repository.UserRepository;

import java.util.List;

public class UserService {
    public static List<User> findAll() {
        List<User> users = UserRepository.findAll();

        users.forEach(u -> System.out.printf("ID: %s | EMAIL: %s | FIRST NAME: %s | LAST NAME: %s | PASSWORD: %s%n",
                u.getId(), u.getEmail(), u.getFirstName(), u.getLastName(), u.getPassword()));

        return users;
    }

    public static User findById(Integer id) {
        return UserRepository.findById(id);
    }

    public static User findByEmail(String email) {
        return UserRepository.findByEmail(email);
    }

    public static void save(User user) {
        User userFromDatabase = UserRepository.findByEmail(user.getEmail());

        if (userFromDatabase != null) {
            throw new HttpException(HttpStatusCode.CONFLICT, "User with this email already exist");
        } else {
            UserRepository.save(user);
        }
    }

    public static User update(User user, Integer id) {
        User userFromDatabase = UserRepository.findById(id);

        if (userFromDatabase == null) {
            throw new HttpException(HttpStatusCode.NOT_FOUND, "No users found with this id.");
        } else {
            return UserRepository.update(user, id);
        }
    }

    public static void delete(Integer id) {
        User user = UserRepository.findById(id);

        if (user == null) {
            throw new HttpException(HttpStatusCode.GONE, "User not found.");
        }
        UserRepository.delete(id);
    }
}
