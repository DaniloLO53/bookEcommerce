import domain.User;
import service.UserService;

public class Init {
    public static void main(String[] args) {
        User user = User.builder()
                .email("dan@gmail.com")
                .firstName("Dan")
                .lastName("L.")
                .password("123")
                .build();
        UserService.findByEmail(user.getEmail()).stream().map(User::getFirstName).forEach(System.out::println);
    }
}
