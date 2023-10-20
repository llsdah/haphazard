package org.example.counter;

public class RaceConditionDemo {

    public static void main(String[] args) {

        // 레이스컨디션 결과가 발생 확인 가능 : 여러 쓰레드 하나의 자원에 접촉

        Counter counter = new Counter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        Thread t3 = new Thread(counter);

        t1.start();
        t2.start();
        t3.start();

    }
}
