import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {
        initServer(5000);
    }

    static void initServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socketClient = serverSocket.accept();
                System.out.println("Socket client: " + socketClient.getInetAddress());


                String response = """
                        HTTP/1.1 200 OK
                        Content-Type: text/plain
                        
                        Connected
                        """;

                OutputStream outputStream = socketClient.getOutputStream();
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();

                socketClient.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}