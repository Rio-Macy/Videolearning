package com.duyi.test;

public class Farmer {

    private Pig pig;

    public Pig keepPig() {

        Pig pig = new Pig("佩奇");
        System.out.println("农民养猪...");

        return pig;
    }

}
