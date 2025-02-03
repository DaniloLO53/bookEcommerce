import domain.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        User dumbUser = new User("a@b.com", "a", "b", "123");
        User dumbUserUpdated = new User("a_updated@b.com", "a_updated", "b_updated", "123_updated");
//        UserService.save(dumbUser);
//        UserService.deleteById(11);
        UserService.printAll();
//        User user = UserService.findByEmail(dumbUser.getEmail());
//        UserService.update(dumbUserUpdated, userId);
    }
}
