package org.example.calculator;

public class PositiveOperator {
    private final int value;
    public PositiveOperator(int value){
        validate(value);
        this.value=value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)) {
            System.out.println(value);
            throw new IllegalArgumentException("0또는 음수는 올수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt(){
        return value;
    }


}
