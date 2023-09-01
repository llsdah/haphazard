package org.example.calculator;

import net.bytebuddy.implementation.bytecode.Throw;

public class DivitionOperator implements NewArithmeticOperator{

    @Override
    public boolean supports(String operator) {
        return operator.equals("/");
    }

    @Override
    public int calculator(int operator1, int operator2) {

        if(operator2==0){
            throw new IllegalArgumentException("???");
        }
        return operator1/operator2;
    }
}
