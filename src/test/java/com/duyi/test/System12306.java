package com.duyi.test;

import java.util.Vector;


/**
 *  System12306使用单例模式， 使用Vector存储车票（现场安全）
 */

public class System12306 {

    private static System12306 system12306 = new System12306();

    private Vector<Ticket> ticketVector = new Vector(100);

    {
        for (int i = 1; i <= 100; i++) {

            ticketVector.add(new Ticket("奥布里斯特" + i, "艾尔巴夫" + i, 100));
        }
    }
    private System12306() {

    }

    public static System12306 getSystem12306() {
        return system12306;
    }

    public Ticket getTicketVector() {
        try {

            // 把票买给乘客
            return ticketVector.remove(0);
        } catch (Exception e) {

            return null;
        }
    }
}
