package com.duyi.test;

public class Object1 extends Thread {

    String show = "show";

    @Override
    public  void run() {

        synchronized (show) {

            show.notify();
            for (int i = 0; i < 50; i++) {

                System.out.print(1 + (i*2)+ ",");
                System.out.println(show.hashCode());
                try {
                    show.notifyAll();
                    show.wait();
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }


        }
    }
}
