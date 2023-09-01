package org.example.mvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidationTest {

    public static final String WRONG_PASSWORD_EXCEPTION_MESSAGE = "비밀번호가 최소 8자리 이상, 12자 이하면 에러가 발생하지 않는다.";

    @DisplayName(WRONG_PASSWORD_EXCEPTION_MESSAGE)
    @Test
    void validPasswordTest() {
        assertThatCode(() -> PasswordValidtor.validate("12341234123")).doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미안 또는 12자 초과하는 경우 IligalArgumentException 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {"11bbccdd","11bbccddffee"})
    @Test
    void vaildatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidtor.validate(password))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("비밀번호는 최소 8차 이상 12자 이하여야 한다.");
    }
}
