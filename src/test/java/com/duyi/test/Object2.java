package com.duyi.test;

public class Object2 extends Thread {

    String show = "show";

    @Override
    public  void run() {

        synchronized (show) {

            show.notify();
            for (int i = 0; i < 50; i++) {

                System.out.print(2 + (i*2)+ ",");
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
