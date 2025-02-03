package httpServer.handlers.user.get;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import domain.User;
import service.UserService;

import java.util.List;

public class UserHandlerGet {
    public static void handle(HttpExchange exchange, String requestPath) {
        System.out.println("Request path: " + requestPath);
        if (requestPath.equals("/users") || requestPath.equals("/users/")) {
            findAll(exchange);
        }
    }

    static void findAll(HttpExchange exchange) {
        Gson gson = new Gson();

        List<User> usersList = UserService.findAll();
        String jsonArray = gson.toJson(usersList);

        sendResponse(exchange, 200, jsonArray);
    }

    static void sendResponse(HttpExchange exchange, Integer statusCode, String responseBody) {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "application/json; charset=UTF-8");
    }
}
