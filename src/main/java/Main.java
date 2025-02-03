import domain.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        User dumbUser = new User("a@b.com", "a", "b", "123");
        UserService.saveUser(dumbUser);
//        UserService.deleteById(11);
        UserService.printAll();
    }
}
