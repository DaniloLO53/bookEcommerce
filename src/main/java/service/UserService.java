package service;

import domain.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    public static void printAll() {
        List<User> users = UserRepository.findAll();

        users.forEach(u -> System.out.printf("ID: %s | EMAIL: %s | FIRST NAME: %s | LAST NAME: %s | PASSWORD: %s%n",
                u.getId(), u.getEmail(), u.getFirstName(), u.getLastName(), u.getPassword()));
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
            System.out.println("User with this email already exist");
        } else {
            UserRepository.save(user);
        }
    }

    public static void update(User user, Integer id) {
        User userFromDatabase = UserRepository.findById(id);

        if (userFromDatabase == null) {
            System.out.println("No users found with this id");
        } else {
            User newUser = UserRepository.update(user, id);

            if (newUser != null) {
                System.out.println("New user created: " + user);
            } else {
                System.out.println("User is null");
            }
        }
    }

    public static void delete(Integer id) {
        User user = UserRepository.findById(id);

        if (user == null) {
            System.out.println("No users found with this id");
        } else {
            UserRepository.delete(id);
        }
    }
}
