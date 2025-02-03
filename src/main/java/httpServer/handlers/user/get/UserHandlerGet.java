package httpServer.handlers.user.get;

import com.sun.net.httpserver.HttpExchange;
import service.UserService;

public class UserHandlerGet {
    public static void handle(HttpExchange exchange, String requestPath) {
        System.out.println("Request path: " + requestPath);
        if (requestPath.equals("/users") || requestPath.equals("/users/")) {
            UserService.findAll();
        }
    }

    private void sendResponse(HttpExchange exchange, Integer statusCode, String responseBody) {

    }
}
