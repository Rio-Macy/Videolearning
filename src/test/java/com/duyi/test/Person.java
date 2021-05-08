package com.duyi.test;

import java.io.File;
import java.io.IOException;

public class Person extends Animal {

    private String name;
    private Integer age;

    {
        System.out.println("person的代码块....");
    }

    public Person() {

        this("name");
        System.out.println("Person的无参构造方法...");
    }

    public Person(String name) {

//        this(name, 1);
        super();
        this.name = name;
        System.out.println("有参构造方法:name...");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("age...");
    }

    public static void fun() {

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) throws InterruptedException {

        super.eat();
        super.getHeight();
        this.sum();
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public void sum() {

        super.sum();

    }

    @Override
    public void eat() throws InterruptedException {

        File file = new File("D:\\test\\file.txt");

        file.wait();
    }

    @Override
    public void file() throws InterruptedException {

        File file = new File("D:\\test\\file.txt");

        file.wait();
        file.mkdirs();
    }

    @Override
    public Integer write() {

        String code = "sshow codsae";
        String li = "I love youds";
        System.out.println("fafdsa ");
        String show = "cshao";
        return 90;
    }
}
