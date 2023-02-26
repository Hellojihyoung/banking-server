package numble.bankingserver.global.handler;

import numble.bankingserver.global.response.ResponseStatus;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private ResponseStatus error;

    public ResponseStatus getErrorCode() {
        return error;
    }

    public CustomException(ResponseStatus e) {
        super(e.getMessage());
        this.error = e;
    }
}