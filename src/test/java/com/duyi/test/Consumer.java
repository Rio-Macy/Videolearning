package com.duyi.test;

public class Consumer extends Thread{

    private Warehouse warehouse;

    public Consumer(Warehouse warehouse) {

        this.warehouse = warehouse;
    }

    @Override
    public void run() {

        while (true) {

            warehouse.get();
            System.out.println("消费者拿走了一件货物");

            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
