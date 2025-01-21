import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    private static final int PORT = 8080;

    public static void initServer() {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            serverSocket.accept();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
