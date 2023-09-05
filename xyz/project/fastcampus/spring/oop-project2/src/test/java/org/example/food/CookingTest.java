package org.example.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {

    @DisplayName("메뉴의 음식을 만든다")
    @Test
    void createTest() {
        Cooking cooking = new Cooking();
        MenuItem menuItem = new MenuItem("돈까스",10000);
        Cook cook = cooking.makeCook(menuItem);

        assertThat(cook).isEqualTo(new Cook("돈까스",10000));
    }
}
