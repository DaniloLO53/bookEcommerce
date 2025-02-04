package httpServer.handlers.user;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import domain.User;
import httpServer.HttpStatusCode;
import service.UserService;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UserHandlerPost {
    public static void handle(HttpExchange exchange, String requestPath) {
        System.out.println("Request path: " + requestPath);

        if (requestPath.equals("/users")) {
            create(exchange);
        }
    }

    public static void create(HttpExchange exchange) {
        try (InputStream requestBody = exchange.getRequestBody()) {
            InputStreamReader inputStreamReader = new InputStreamReader(requestBody);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Gson gson = new Gson();
            User newUser = gson.fromJson(bufferedReader, User.class);

            try {
                UserService.save(newUser);
                sendResponse(exchange, HttpStatusCode.CREATED, "CREATED");
            } catch (RuntimeException e) {
                sendResponse(exchange, HttpStatusCode.CONFLICT, e.getMessage());
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendResponse(HttpExchange exchange, HttpStatusCode statusCode, String responseBody) {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html; charset=UTF_8");
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
