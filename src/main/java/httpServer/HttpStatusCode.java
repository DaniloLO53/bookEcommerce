package httpServer;

public enum HttpStatusCode {
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    GONE(410);

    private final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
