package httpServer;

public enum HttpStatusCode {
    OK(200),
    CREATED(201),
    NOT_FOUND(400),
    CONFLICT(409);

    private final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
