package org.example.calculator;

import org.example.calculate.PositiveOperator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositiveOperatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void createTest(int value){
        assertThatCode(()-> new PositiveOperator(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 또는 음수는 올 수 없다.");
    }
}
