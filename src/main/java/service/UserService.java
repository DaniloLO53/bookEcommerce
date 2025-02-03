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

    public static void saveUser(User user) {
        User userFromDatabase = UserRepository.findByEmail(user.getEmail());

        if (userFromDatabase != null) {
            System.out.println("User with this email already exist");
        } else {
            UserRepository.save(user);
        }
    }

    public static void deleteById(Integer id) {
        User user = UserRepository.findById(id);

        if (user == null) {
            System.out.println("No users found with this id");
        }

        UserRepository.deleteById(id);
    }
}
