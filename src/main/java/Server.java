import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Server {
    public static void main(String[] args) {
        initServer(5000);
    }

    private static void getDogs() {
        Path path = Path.of("dogs.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getDog(int id) {
        Path path = Path.of("dogs.txt");

        try (Stream<String> line = Files.lines(path).filter(ln -> ln.contains("id:" + id))) {
            System.out.println(line.collect(Collectors.joining()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void initServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socketClient = serverSocket.accept();

                InputStreamReader inputStreamReader = new InputStreamReader(socketClient.getInputStream());
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String path = reader.lines().findFirst().orElse("").split(" ")[1];

                String response = getResponse(path);
                getDog(1);

                OutputStream outputStream = socketClient.getOutputStream();
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();

                socketClient.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getResponse(String path) {
        String response = """
                HTTP/1.1 200 OK
                Content-Type: text/plain
                """;

        if (path.equals("/test")) {
            response += "\n test";
        } else if (path.equals("/")) {
            response += "\n home";
        } else {
            response = """
                HTTP/1.1 404 Not Found
                Content-Type: text/plain
                
                Not found
                """;
        }
        return response;
    }
}