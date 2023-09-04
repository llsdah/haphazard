package org.example.calculate;

import org.example.calculate.NewArithmeticOperator;
import org.example.calculate.PositiveOperator;

public class SubtractOperator implements NewArithmeticOperator {

    @Override
    public boolean supports(String operator) {
        return operator.equals("-");
    }

    @Override
    public int calculator(PositiveOperator operator1, PositiveOperator operator2) {
        return operator1.toInt()-operator2.toInt();
    }
}
