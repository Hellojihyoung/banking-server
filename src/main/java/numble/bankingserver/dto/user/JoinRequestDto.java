package numble.bankingserver.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.bankingserver.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class JoinRequestDto {
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 양식 오류")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "사용자 이름을 입력해주세요")
    private String username;


    @Builder
    public JoinRequestDto(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }
}