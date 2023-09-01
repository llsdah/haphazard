package org.example.calculator;

import net.bytebuddy.implementation.bytecode.Addition;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int calculate(int operator1, int operator2) {
            return operator1+operator2;
        }
    },
    DIVITION("/") {
        @Override
        public int calculate(int operator1, int operator2) {
            return operator1/operator2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int calculate(int operator1, int operator2) {
            return operator1*operator2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int calculate(int operator1, int operator2) {
            return operator1-operator2;
        }
    };

    private final String opertor;

    ArithmeticOperator(String opertor) {
        this.opertor = opertor;
    }
    public static int calculate(int operator1,String opertor, int operator2){
        ArithmeticOperator arithmeticOperator =  Arrays.stream(values())
                .filter(v -> v.opertor.equals(opertor))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("올바른 사칙연산이 없습니다."));
        return arithmeticOperator.calculate(operator1,operator2);
    }


    public abstract int calculate(final int operator1, final int operator2);

}
