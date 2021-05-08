package com.duyi.test;

public class Stadium extends Thread {

    private RunMan runMan;


    public Stadium(RunMan runMan) {
        this.runMan = runMan;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(runMan.getName() + "跑到第" + i + "米");
        }
    }
}
