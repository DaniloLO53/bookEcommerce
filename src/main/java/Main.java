import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService.deleteById(3);
        UserService.printAll();
    }
}
