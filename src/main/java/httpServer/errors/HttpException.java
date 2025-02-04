package httpServer.errors;

import httpServer.HttpStatusCode;

public class HttpException extends RuntimeException {
    private final HttpStatusCode statusCode;

    public HttpException(HttpStatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
