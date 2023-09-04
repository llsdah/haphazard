package org.example.calculate;

public class MultipleOperator implements NewArithmeticOperator{

    @Override
    public boolean supports(String operator) {

        System.out.println("곱하기에 들어오냐 "+operator+operator.equals("*"));
        return operator.equals("*");
    }

    @Override
    public int calculator(PositiveOperator operator1, PositiveOperator operator2) {
        return operator1.toInt()*operator2.toInt();
    }
}
