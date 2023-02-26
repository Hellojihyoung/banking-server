package numble.bankingserver.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import numble.bankingserver.dto.user.JoinRequestDto;
import numble.bankingserver.dto.user.LoginRequestDto;
import numble.bankingserver.global.response.SuccessResponse;
import numble.bankingserver.global.response.ResponseStatus;
import numble.bankingserver.service.UserService;
import numble.bankingserver.vo.user.LoginResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping({"/join"})
    public SuccessResponse join(@Valid @RequestBody final JoinRequestDto requestDto) {
        userService.join(requestDto);
        SuccessResponse response = SuccessResponse.builder()
                .status(ResponseStatus.OK)
                .message("Success Join")
                .build();
        return response;
    }

    @PostMapping({"/login"})
    public SuccessResponse login(@Valid @RequestBody final LoginRequestDto requestDto) {
        LoginResponseVo responseVo = userService.login(requestDto);
        SuccessResponse response = SuccessResponse.builder()
                .status(ResponseStatus.OK)
                .message("Success login")
                .data(responseVo)
                .build();
        return response;
    }

}