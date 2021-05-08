package com.duyi.test;


import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) throws Exception{

//        double d = 0;
//        System.out.println(d);
//        TestMain.fun1("show", 2);
//        Person person = new Person("name");
//        person.eat();

//        Animal animal1 = new Animal();
//        animal1.sum();

//        person.sum();

        //农民杀猪
//        Farmer farmer = new Farmer();
//        Butcher butcher = new Butcher();
//        butcher.killPig(farmer.keepPig());

        // 电脑机房和学生
//        Room room = new Room();
//        Student student1 = new Student("1");
//        Student student2= new Student("2");
//        Student student3 = new Student("3");
//        Student student4 = new Student("4");
//        Student student5 = new Student("5");
//        Student student6 = new Student("6");
//
//        room.leaning(student1);
//        room.leaning(student2);
//        room.leaning(student3);
//        room.leaning(student4);
//        room.leaning(student5);
//        room.leaning(student6);

        // 测速器 警车 汽车
//        Car car = new Car(6);
//        Speedometer speedometer = new Speedometer();
//        speedometer.seSu(car);

//        SingleTon singleTon = SingleTon.getSingleTon();
//        SingleTon singleTon1 = SingleTon.getSingleTon();
//
//        Integer integer = new Integer(123);
//
//        int i = integer.intValue();
//        System.out.println(123 == i);
//
//        String str = "show";
//        System.out.println(str.equals("show"));
//
//        Integer iq = 12;
//        Integer iw = 12;
//        System.out.println(iq == iw);

//            工具类

//        float f = 1231.124f;
//        double d = 1234.1234d;
//
//        System.out.println(Math.abs(f));
//        System.out.println(Math.abs(d));
//
//        int i = (int) 123.5f;
//        int j = 1231;
//        System.out.println(Math.ceil(d));
//        System.out.println(Math.floor(d));
//
//        double d1 = Math.floor(d);
//
//        int i2 = Math.max(234, 31);
//        Math.round(d);
//
//        System.out.println(i2);
//
////        String s3 = new String("abc");
//        String s2 = new String("abc");
//        s2 = "afas";
//        System.out.println(s2.toString());
//        String s1 = "abc";
//        String s4 = "abc";

//        System.out.println(s2 == s3);
//        System.out.println(s1 == s4);

//        String str2 = "abc" + "123" + "4321";
//        System.out.println(str2);

//        Stadium stadium = new Stadium(new RunMan("苏炳添s"));
//        stadium.start();
//        Stadium stadium1 = new Stadium(new RunMan("苏炳添d"));
//        stadium1.start();
//        Stadium stadium2 = new Stadium(new RunMan("苏炳添f"));
//        stadium2.start();

//        Windows windows1 = new Windows("1号窗口");
//        windows1.start();
//        Windows windows2 = new Windows("2号窗口");
//        windows2.start();
//        Windows windows3 = new Windows("3号窗口");
//        windows3.start();

//        double d = 123.12;
//        int i = (int) (d * 100);
//        System.out.println(i);
//
//        double m = 0.01;
//        System.out.println(m);


//
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(123);

//        final Object object = new Object();
//        new Thread(new Runnable() {
//            @Override
//            public synchronized void run() {
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

//        Object1 object1 = new Object1();
//        object1.start();
//
//        Object2 object2 = new Object2();
//        object2.start();

//        Warehouse warehouse = new Warehouse();
//        Producer p = new Producer(warehouse);
//       // 设置线程优先级别
//        p.setPriority(10);
//
//        Consumer consumer1 = new Consumer(warehouse);
//        Consumer consumer2 = new Consumer(warehouse);
//
//        p.start();
//        consumer1.start();
//        consumer2.start();

        // 哲学家
//        Chopstick c1 = new Chopstick(1);
//        Chopstick c2 = new Chopstick(2);
//        Chopstick c3 = new Chopstick(3);
//        Chopstick c4 = new Chopstick(4);
//
//        Philosopher p1 = new Philosopher("哲学家a",c2,c1,0);
//        Philosopher p2 = new Philosopher("哲学家b",c3,c2,3000);
//        Philosopher p3 = new Philosopher("哲学家c",c4,c3,0);
//        Philosopher p4 = new Philosopher("哲学家d",c1,c4,3000);
//
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();

//        ThreadOne threadOne1 = new ThreadOne("one");
//        threadOne1.start();
//        ThreadOne threadOne2 = new ThreadOne("twe");
//        threadOne1.start();
//        threadOne2.start();
//        threadOne1.join();

          ThreadOne threadOne1 = new ThreadOne("one");
          threadOne1.start();
    }

    public static void fun1() {

        System.out.println("fun1...");
    }

    private static void fun1(int i) {

        System.out.println("fun2...");
    }

    public static void fun1(String string, String i) {

        System.out.println("fun3...");
    }

    public static String fun1(String string, int i) {

        System.out.println("fun4...");

        return "string";
    }

}
