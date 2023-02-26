package numble.bankingserver.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(length = 500)
    private String refreshToken;

    @CreationTimestamp
    private Timestamp create_date;

    @CreationTimestamp
    private Timestamp update_date;

    @Builder
    public UserToken(Long userId, String refreshToken) {

        this.userId = userId;
        this.refreshToken = refreshToken;

    }
}
