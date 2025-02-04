package httpServer.handlers.user;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import domain.User;
import httpServer.HttpStatusCode;
import service.UserService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserHandlerGet {
    public static void handle(HttpExchange exchange, String requestPath) {
        System.out.println("Request path: " + requestPath);
        if (requestPath.equals("/users")) {
            findAll(exchange);
        }
        if (requestPath.matches("^/users/\\d+$")) {
            findById(exchange, requestPath.split("/")[2]);
        }
    }

    static void findAll(HttpExchange exchange) {
        Gson gson = new Gson();

        List<User> usersList = UserService.findAll();
        String json = gson.toJson(usersList);

        sendResponse(exchange, HttpStatusCode.OK, json);
    }

    static void findById(HttpExchange httpExchange, String id) {
        Gson gson = new Gson();

        User user = UserService.findById(Integer.valueOf(id));
        String json = gson.toJson(user);


        sendResponse(httpExchange, HttpStatusCode.CREATED, json);
    }

    static void sendResponse(HttpExchange exchange, HttpStatusCode statusCode, String responseBody) {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "application/json; charset=UTF_8");

        byte[] responseBodyBytes = responseBody.getBytes(StandardCharsets.UTF_8);

        try {
            exchange.sendResponseHeaders(statusCode.getCode(), responseBodyBytes.length);

            try (OutputStream outputStream = exchange.getResponseBody()) {
                outputStream.write(responseBodyBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
