package org.example.calculator;

public interface NewArithmeticOperator {
    boolean supports(String operator);

    int calculator(PositiveOperator operator1, PositiveOperator operator2);
}
