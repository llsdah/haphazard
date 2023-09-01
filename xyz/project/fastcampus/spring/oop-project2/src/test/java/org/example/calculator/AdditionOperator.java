package org.example.calculator;

public class AdditionOperator implements NewArithmeticOperator{

    @Override
    public boolean supports(String operator) {
        return operator.equals("+");
    }

    @Override
    public int calculator(int operator1, int operator2) {
        return operator1+operator2;
    }
}
