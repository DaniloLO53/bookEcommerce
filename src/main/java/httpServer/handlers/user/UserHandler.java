package httpServer.handlers.user;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class UserHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestPath = exchange.getRequestURI().getPath().replaceAll("/$", "");
        String requestMethod = exchange.getRequestMethod();

        switch (requestMethod) {
            case "GET":
                UserHandlerGet.handle(exchange, requestPath);
                break;
            case "POST":
                UserHandlerPost.handle(exchange, requestPath);
                break;
            case "PUT":
                UserHandlerUpdate.handle(exchange, requestPath);
                break;
            case "DELETE":
                UserHandlerDelete.handle(exchange, requestPath);
                break;
            default:
                System.out.println("Invalid method.");
        }
    }
}
