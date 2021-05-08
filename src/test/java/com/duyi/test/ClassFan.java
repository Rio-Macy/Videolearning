package com.duyi.test;


import java.util.*;

public class ClassFan {

    public static void main(String[] args) {

//        ArrayList arrayList = new ArrayList();

        Vector vector = new Vector(2, 4);
        vector.add(1);
        vector.add(2);
        vector.add(23);
//        vector.add(223);
//        vector.add(24);
//        vector.add(24);
//
//        vector.add(24);
//        vector.add(24);

        System.out.println(vector.size());
        System.out.println(vector.capacity());

        System.out.println(((float) vector.size() / (float) vector.capacity()));

        Vector<String> vector1 = new Vector<String>(4, 4);

        for (int i = 0; i <= 22; i++) {

            vector1.add("a");
            System.out.println(vector1.size() + "----" + vector1.capacity());

        }
//
//        Stack<String> stack = new Stack<String>();
//
//        stack.push("a");
//        stack.push("b");
//        stack.push("c");
//
//        System.out.println(stack);
//        System.out.println(stack.peek()); // c
//        System.out.println(stack);
//        System.out.println(stack.search("b"));
//
//        Set set = new HashSet<>();
//
//        System.out.println(set);
//        set.add("af");
//
//        set.addAll(stack);
//        set.add(12);
//        set.remove(12);
//
//
//        System.out.println(set);

        TreeSet treeSet = new TreeSet();
//        treeSet.add(new Cow(2, "w2"));
//        treeSet.add(new Cow(3, "w3"));
//        treeSet.add(new Cow(1, "w1"));
//
//
//        treeSet.add(new Cow(4, "w4"));
//
//        System.out.println(treeSet);

//        HashSet<Cow> cows = new HashSet<>();
//        cows.add(new Cow(2, "w2"));
//        cows.add(new Cow(3, "w3"));
//        cows.add(new Cow(4, "fa"));
//
//        System.out.println(cows);

        Map map = new HashMap();
        map.put("fa", 32);
        map.put("ad", 322);
        map.put("fa1", 341);
        map.put(null, "r4");
        map.put("null", 123141);
        TreeMap treeMap = new TreeMap();
        treeMap.put("fa", 24);
        treeMap.put("null" , 23);

        System.out.println(treeMap);


    }

}
