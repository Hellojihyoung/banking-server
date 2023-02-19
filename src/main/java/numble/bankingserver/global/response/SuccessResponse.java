package numble.bankingserver.global.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SuccessResponse {
    private ResponseCode status;
    private String message;
    private Object data;

    @Builder
    public SuccessResponse(ResponseCode status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}