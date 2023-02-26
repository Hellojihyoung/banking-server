package numble.bankingserver.global.response;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {

    // Success
    OK(HttpStatus.OK, "OK"),

    // Fail
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "BAD_REQUEST"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "FORBIDDEN"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "NOT_FOUND"),
    CONFLICT(HttpStatus.CONFLICT, "CONFLICT"),
    INTERNAL_SERER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");

    HttpStatus status;
    String message;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    ResponseStatus(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}