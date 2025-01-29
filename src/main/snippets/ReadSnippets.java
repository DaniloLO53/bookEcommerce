import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Readnippets {
    public static void main(String[] args) {
    }

    static void snippet1(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socketClient = serverSocket.accept();
                System.out.println("Socket client: " + socketClient.getInetAddress());

                InputStreamReader inputStreamReader = new InputStreamReader(socketClient.getInputStream());

                BufferedReader reader = new BufferedReader(inputStreamReader);
                // 2 ways to read
                reader.read();
                reader.lines().forEach(System.out::println);

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