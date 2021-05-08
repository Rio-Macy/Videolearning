package com.duyi.test;

import java.util.Vector;

public class Windows extends Thread {


    private String windowsName;

    public Windows(String windowsName) {

        this.windowsName = windowsName;
    }

    @Override
    public void run() {

        this.sellTicket();
    }

    public void sellTicket() {

        while (true) {

            System12306 system12306 = System12306.getSystem12306();
            Ticket ticket = system12306.getTicketVector();

            if (ticket == null) {

                System.out.println("票以买卖");
                break;
            }
            System.out.println(this.windowsName + ticket);
        }
    }
}
