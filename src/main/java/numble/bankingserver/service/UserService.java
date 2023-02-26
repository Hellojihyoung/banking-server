package numble.bankingserver.service;

import jakarta.persistence.EntityNotFoundException;
import numble.bankingserver.dto.user.*;
import numble.bankingserver.domain.User;
import numble.bankingserver.domain.UserToken;
import numble.bankingserver.global.handler.CustomException;
import numble.bankingserver.global.jwt.*;
import numble.bankingserver.global.jwt.dto.JwtResponseDto;
import numble.bankingserver.global.response.ResponseStatus;
import numble.bankingserver.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import numble.bankingserver.repository.UserTokenRepository;
import numble.bankingserver.vo.user.LoginResponseVo;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserTokenRepository tokenRepository;
//    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    private void duplicateEmail(String email) {
        userRepository.findByEmail(email).ifPresent(u -> {
                    throw new IllegalArgumentException("Duplicated User");
                }
        );
    }

    public void join(JoinRequestDto joinRequestDto) {
        System.out.println("=====service===");
        duplicateEmail(joinRequestDto.getEmail());
        userRepository.save(joinRequestDto.toEntity());
    }

    public LoginResponseVo login(LoginRequestDto loginRequestDto) {
        String email = loginRequestDto.toEntity().getEmail();
        String password = loginRequestDto.toEntity().getPassword();

        User findUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User Doesn't exist"));

        String exactPassword = findUser.getPassword();

        if (!exactPassword.equals(password)) {
            throw new CustomException(ResponseStatus.UNAUTHORIZED);
        }

        Long UserId = findUser.getId();
//        UsernamePasswordAuthenticationToken authenticationToken = loginRequestDto.toAuthentication();
//        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
//        JwtResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(UserId, authentication);
//
//        tokenRepository.findById(UserId).ifPresentOrElse(
//                t -> {
//                    t.builder()
//                            .refreshToken(tokenInfo.getRefreshToken())
//                            .build();
//                    tokenRepository.save(t);
//                }, () -> {
//                    UserToken ut = UserToken.builder()
//                            .userId(UserId)
//                            .refreshToken(tokenInfo.getRefreshToken())
//                            .build();
//                    tokenRepository.save(ut);
//                }
//        );

        return new LoginResponseVo(
//                tokenInfo.getAccessToken(),
//                tokenInfo.getRefreshToken()
                UserId
        );
    }



    // 비밀번호 변경
}