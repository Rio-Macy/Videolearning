package com.duyi.test;

import com.duyi.test.ptest.TestClass;

public class TestClass1 {

    public static void main(String[] args) {

        TestClass testClass = new TestClass();
//        testClass.test1();
        System.out.println(TestClass1.finallyTest());

        Animal animal = new Animal();
        Animal animal1 = new Animal();
        animal.staticNumber++;
        animal1.staticNumber ++;
        animal1.write();
        System.out.println(animal.staticNumber);

    }

    public static String finallyTest() {

        try {

            System.out.println("show time");
        } finally {

            return "finally";
        }

//        return "tao";
    }
}
