package org.example.calculate;

public interface NewArithmeticOperator {
    boolean supports(String operator);

    int calculator(PositiveOperator operator1, PositiveOperator operator2);
}
