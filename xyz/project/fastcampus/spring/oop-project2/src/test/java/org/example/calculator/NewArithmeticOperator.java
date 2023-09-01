package org.example.calculator;

public interface NewArithmeticOperator {
    boolean supports(String operator);

    int calculator(int operator1, int operator2);
}
