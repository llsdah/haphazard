package org.example.food;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 음식 주문과정 구현
 * 1. 도메인 구성 객체 생각 : 손님, 메뉴판, 음식, 요리사, 요리
 * 2. 객체 관계 : 손님 - 메뉴판, 손님 - 요리사 , 요리사 - 요리
 * 3. 동적 객체 정적 타입 추상화 모델링 : 손님 - 손님, 돈까스 등 - 요리, 메뉴판 - 메뉴판, 메뉴 - 메뉴
 * 4. 협력 관계
 * 5. 객체 포관하는 타입에 책임할당
 * 6. 구현
 */
public class CustomerTest {

    @DisplayName("메뉴이름에 해당하는 메뉴를 주문한다.")
    @Test
    void createTest(){
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스",10000), new MenuItem("만두",5000)));
        Cooking cooking = new Cooking();
        assertThatCode(() -> customer.order("만두",menu,cooking))
                .doesNotThrowAnyException();
    }

}
