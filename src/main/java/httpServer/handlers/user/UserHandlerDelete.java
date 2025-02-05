package httpServer.handlers.user;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import httpServer.HttpStatusCode;
import httpServer.errors.HttpException;
import service.UserService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserHandlerDelete {
    public static void handle(HttpExchange exchange, String requestPath) {
        if (requestPath.matches("^/users/\\d+$")) {
            delete(exchange, requestPath.split("/")[2]);
        }
    }

    public static void delete(HttpExchange exchange, String id) {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html; charset=UTF_8");

        try {
            UserService.delete(Integer.valueOf(id));
            sendResponse(exchange, HttpStatusCode.NO_CONTENT);

        } catch (HttpException e) {
            sendResponse(exchange, e.getStatusCode(), e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sendResponse(HttpExchange exchange, HttpStatusCode statusCode) {
        sendResponse(exchange, statusCode, "");
    }

    public static void sendResponse(HttpExchange exchange, HttpStatusCode statusCode, String responseBody) {
        boolean noBody = responseBody.isEmpty();

        try {
            exchange.sendResponseHeaders(statusCode.getCode(), noBody ? -1 : responseBody.length());

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
