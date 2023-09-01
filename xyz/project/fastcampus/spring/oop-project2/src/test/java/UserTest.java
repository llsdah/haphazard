import org.example.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DisplayName("패스워드 초기와 여부 판다")
    @Test
    void passwordTest(){
        //given
        User user = new User();

        // when
        user.initPassword(new CorrectPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNotNull();
    }
    @DisplayName("패스워드 초기화가 되지 않는다")
    @Test
    void passwordTest2(){
        //given
        User user = new User();

        // when
        user.initPassword(new WrongPasswordGenerator());

        // then
        assertThat(user.getPassword()).isNotNull();
    }
}
