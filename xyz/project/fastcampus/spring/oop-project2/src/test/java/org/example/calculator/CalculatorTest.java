package org.example.calculator;

import org.example.calculate.Calculator;
import org.example.calculate.PositiveOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 간단 사칙연산 구현가능
 * 양수 계산 가능
 * 나눗셈에서 0을 나누는 경우 IlliagalArgument 예외 처리한다.
 * mvc 기반으로 만든다.
 */


public class CalculatorTest {

    @DisplayName("사칙 연산을 할 수 있다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calaulatorTest(String operator, int operate1, int operate2, int result){
        int calculatorResult = Calculator.calculator(new PositiveOperator(operate1),operator, new PositiveOperator(operate2));
        System.out.println(calculatorResult);
        assertThat(calculatorResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){

        return Stream.of(
                arguments("+",1,1,2),
                arguments("-",1,1,0),
                arguments("*",1,1,1),
                arguments("/",1,1,1),
                arguments("/",1,1,4)
        );
    }

}
