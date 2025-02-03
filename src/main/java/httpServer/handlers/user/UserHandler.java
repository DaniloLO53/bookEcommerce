package httpServer.handlers.user;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import httpServer.handlers.user.get.UserHandlerGet;

import java.io.IOException;

public class UserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestPath = exchange.getRequestURI().getPath();
        String requestMethod = exchange.getRequestMethod();

        switch (requestMethod) {
            case "GET":
                UserHandlerGet.handle(exchange, requestPath);
                break;
            case "POST":
                // todo
                break;
            case "UPDATE":
                // todo
                break;
            case "DELETE":
                // todo
                break;
            default:
                System.out.println("Method invalid");
        }
    }
}
