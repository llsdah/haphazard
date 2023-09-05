package org.example.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuTest {

    @DisplayName("메뉴이름에 대한하는 메뉴를 반환한다")
    @Test
    void createTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스",10000), new MenuItem("만두",5000)));
        MenuItem menuItem = menu.chooes("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스",10000));
    }

    @DisplayName("메뉴판에 없는 이름 작성시 에러 발생한다.")
    @Test
    void createTest2() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스",10000), new MenuItem("만두",5000)));
        MenuItem menuItem = menu.chooes("돈까스");

        assertThatCode(()-> menu.chooes("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴입니다.");
    }
}
