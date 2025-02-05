package httpServer.handlers.auth;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import httpServer.HttpStatusCode;
import service.AuthService;

import java.io.IOException;

public class AuthHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        Headers requestHeaders = exchange.getRequestHeaders();

        String authorizationHeader = requestHeaders.get("Authorization").getFirst();
        AuthService.decoder(authorizationHeader);

        if (requestMethod.equals("POST")) {
            authenticate();
        }
    }

    static void sendResponse(HttpExchange exchange, HttpStatusCode statusCode, String responseBody) {

    }

    public void authenticate() {

    }
}
