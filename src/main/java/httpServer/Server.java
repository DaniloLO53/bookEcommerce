package httpServer;

import com.sun.net.httpserver.HttpServer;
import httpServer.handlers.user.UserHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);

            server.createContext("/users", new UserHandler());

            server.setExecutor(null);
            server.start();

            System.out.println("Server listening at port 5000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
