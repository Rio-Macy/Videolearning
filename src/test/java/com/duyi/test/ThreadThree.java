package com.duyi.test;

public class ThreadThree extends Thread {

    private ThreadTwo threadTwo;

    ThreadThree(ThreadTwo threadTwo) {

        this.threadTwo = threadTwo;
    }

    @Override
    public void run() {

        //在two执行的过程中  one等待的过程中   three将two对象锁定
        System.out.println("thread-three start");

        synchronized (threadTwo) {

            System.out.println("threadTwe is locked");

            try {

                Thread.sleep(10000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            System.out.println("threadTwo is free");
        }

        System.out.println("thread-three end");
    }
}
