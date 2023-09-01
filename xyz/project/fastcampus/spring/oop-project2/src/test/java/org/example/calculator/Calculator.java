package org.example.calculator;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperator =
            List.of(new AdditionOperator(), new SubtractOperator(), new MultipleOperator(), new DivitionOperator());

    public static int calculator(PositiveOperator operator1, String operatorStr,PositiveOperator operator2){
//        int result = ArithmeticOperator.calculate(operator1,operatorStr,operator2);
        System.out.println("oper + "+operatorStr.equals("*"));
        int result = arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operatorStr))
                .map(arithmeticOperator -> arithmeticOperator.calculator(operator1,operator2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 없습니다."));
        return result;
    }
}


