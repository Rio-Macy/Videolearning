package com.duyi.test;

public class ThreadOne extends Thread {

    private String name;

    public ThreadOne(String name) {
        this.name = name;
    }
    @Override
    public void run() {

        System.out.println("thread-one start");
        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.start();

        try {
            threadTwo.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread-one end");
    }
}
