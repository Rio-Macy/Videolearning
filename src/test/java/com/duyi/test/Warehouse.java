package com.duyi.test;

import java.util.ArrayList;

public class Warehouse {

    private ArrayList<String> list = new ArrayList<>();

    public synchronized void add() {

        if (list.size() < 20) {

            list.add("a");
        }else {

            try {

                this.notifyAll();
                this.wait(); //仓库调用wait 不是仓库对象等待，而是访问仓库的生产者线程进入等待状态
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public synchronized void get() {

        if (list.size() > 0) {

            list.remove(0);// 集合越界的问题
        }else {

            try {

                this.notifyAll();
                this.wait(); //
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

}
