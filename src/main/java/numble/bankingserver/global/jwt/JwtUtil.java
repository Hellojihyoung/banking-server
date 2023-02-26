package numble.bankingserver.global.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;

@Slf4j
@Component
public class JwtUtil {

    public static Long getPayloadByToken(String token) {
        try {
            String[] splitJwt = token.split("\\.");

            Base64.Decoder decoder = Base64.getDecoder();
            String payload = new String(decoder.decode(splitJwt[1] .getBytes()));
            HashMap<String,?> payloadMap = new ObjectMapper().readValue(payload, HashMap.class);
            Long userId = Long.valueOf(String.valueOf(payloadMap.get("user_id")));

            return userId;
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
