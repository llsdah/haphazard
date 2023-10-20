package org.example.counter;

public class Counter implements Runnable{

    private int count = 0;

    @Override
    public void run() {
        this.increament();
        System.out.println("count : "+this.getCount());

        this.decreament();
        System.out.println("count : "+this.getCount());

    }

    public void increament(){
        count++;
    }
    public void decreament(){
        count--;
    }

    public int getCount(){
        return count;
    }
}
