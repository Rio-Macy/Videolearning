package com.duyi.test;

public class SingleTon {

    private static SingleTon singleTon = new SingleTon();
    public String str;

    private SingleTon() {

    }

    public static SingleTon getSingleTon() {

//        if (singleTon == null) {
//
//            singleTon = new SingleTon();
//        }

        return singleTon;
    }

    public void staticEl() {

        this.getSingleTon();
    }

}
