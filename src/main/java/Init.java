import domain.User;
import repository.UserRepository;

import java.sql.Connection;

public class Init {
    public static void main(String[] args) {
        User user = User.builder()
                .email("dan@gmail.com")
                .firstName("Dan")
                .lastName("L.")
                .password("123")
                .build();
//        UserRepository.save(user);
        UserRepository.findAll();
    }
}
