package httpServer.handlers.user;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import domain.User;
import httpServer.HttpStatusCode;
import httpServer.errors.HttpException;
import service.UserService;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UserHandlerUpdate {
    public static void handle(HttpExchange exchange, String requestPath) {
        if (requestPath.matches("^/users/\\d+$")) {
            update(exchange, requestPath.split("/")[2]);
        }
    }

    public static void update(HttpExchange exchange, String id) {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html; charset=UTF_8");

        try (InputStream requestBody = exchange.getRequestBody()) {
            InputStreamReader inputStreamReader = new InputStreamReader(requestBody);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Gson gson = new Gson();
            User updatedUser = gson.fromJson(bufferedReader, User.class);

            try {
                User newUser = UserService.update(updatedUser, Integer.valueOf(id));
                Gson newGson = new Gson();
                String newUserString = newGson.toJson(newUser);
                sendResponse(exchange, HttpStatusCode.CREATED, newUserString);
            } catch (HttpException e) {
                e.printStackTrace();
                sendResponse(exchange, e.getStatusCode(), e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendResponse(HttpExchange exchange, HttpStatusCode statusCode, String responseBody) {
        try {
            exchange.sendResponseHeaders(statusCode.getCode(), responseBody.length());

            try (OutputStream outputStream = exchange.getResponseBody()) {
                outputStream.write(responseBody.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
