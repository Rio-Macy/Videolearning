package com.duyi.test;

import java.io.File;

public class Animal {

    private Integer height;

    public void eat() throws InterruptedException {
        System.out.println("eat...");
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public void sum() throws RuntimeException{

        System.out.println("sum...");
        int i = 10;
        int i1 = i / 0;
        System.out.println(i1);
        System.out.println("show...");



    }

    public void file() throws InterruptedException {


        File file = new File("D:\\test\\file.txt");

        file.wait();
    }

    public Object write() {

        return 12;
    }
}
