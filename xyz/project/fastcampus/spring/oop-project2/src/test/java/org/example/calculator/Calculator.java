package org.example.calculator;

public class Calculator {

    public static int calculator(int operator1, String operatorStr,int operator2){

        if("+".equals(operatorStr)){
            return operator1+operator2;
        }else if("-".equals(operatorStr)){
            return operator1-operator2;
        }else if("*".equals(operatorStr)){
            return operator1*operator2;
        }else if ("/".equals(operatorStr)){
            return operator1/operator2;
        }
        return 3;
    }
}


