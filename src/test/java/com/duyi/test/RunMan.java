package com.duyi.test;

public class RunMan {

    private String name;

    public RunMan() {
        this("sadf");
    }

    public RunMan(String name) {

//        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
