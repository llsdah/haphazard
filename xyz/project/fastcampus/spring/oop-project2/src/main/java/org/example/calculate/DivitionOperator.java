package org.example.calculate;


public class DivitionOperator implements NewArithmeticOperator{

    @Override
    public boolean supports(String operator) {
        return operator.equals("/");
    }

    @Override
    public int calculator(PositiveOperator operator1, PositiveOperator operator2) {
        //0이 안됩니다.
        return operator1.toInt()/operator2.toInt();
    }
}
