package org.example.calculator;

public class Calculator {

    public static int calculator(int operator1, String operatorStr,int operator2){
        int result = ArithmeticOperator.calculate(operator1,operatorStr,operator2);

        return result;
    }
}


