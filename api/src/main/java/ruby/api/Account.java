package ruby.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String password;

    public Account(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
