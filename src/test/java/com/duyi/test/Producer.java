package com.duyi.test;

public class Producer extends Thread {

    // 为了保证生产者和消费者使用同一个仓库对象 添加Warehouse对象
    private Warehouse warehouse;

    public Producer(Warehouse warehouse) {

        this.warehouse = warehouse;
    }

    @Override
    public void run() {

        while (true) {

            warehouse.add();
            System.out.println("生产者存入了一件货物");

            try {

                Thread.sleep(300);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
