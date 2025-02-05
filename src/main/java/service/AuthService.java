package service;

import httpServer.HttpStatusCode;
import httpServer.errors.HttpException;

public class AuthService {
    public static void decoder(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic")) {
            throw new HttpException(HttpStatusCode.UNAUTHORIZED, "Invalid authorization header");
        }

    }
}
