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
}
