package com.duyi.test;

public class ThreadTwo extends Thread {

    @Override
    public void run() {

        ThreadThree threadThree = new ThreadThree(this);
        threadThree.start();
        try {
            threadThree.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread-two end");
    }
}
