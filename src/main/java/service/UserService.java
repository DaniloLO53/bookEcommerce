package service;

import domain.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    public static void printAll() {
        List<User> users = UserRepository.findByName("da");

        users.forEach(u -> System.out.printf("ID: %s | EMAIL: %s | FIRST NAME: %s | LAST NAME: %s | PASSWORD: %s%n",
                u.getId(), u.getEmail(), u.getFirstName(), u.getLastName(), u.getPassword()));
    }

    public static void deleteById(Integer id) {
        UserRepository.deleteById(id);
    }
}
