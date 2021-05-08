package com.duyi.test;

import java.awt.*;

public class Computer {

    private boolean status;

    public Computer() {

    }
    public Computer(boolean status) {
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void open() {

        this.status = true;
        System.out.println("电脑被打开...");
    }

    public void use() {

        System.out.println("电脑被使用...");
    }

    public void close() {

        this.status = true;
        System.out.println("电脑被关闭...");
    }

}
