package com.duyi.test;

public class Ticket {

    private String StaStation;
    private String Terminal;
    private float price;

    public Ticket() {
    }

    public Ticket(String staStation, String terminal, float price) {
        StaStation = staStation;
        Terminal = terminal;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "StaStation='" + StaStation + '\'' +
                ", Terminal='" + Terminal + '\'' +
                ", price=" + price +
                '}';
    }

    public void setStaStation(String staStation) {
        StaStation = staStation;
    }

    public void setTerminal(String terminal) {
        Terminal = terminal;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStaStation() {
        return StaStation;
    }

    public String getTerminal() {
        return Terminal;
    }

    public float getPrice() {
        return price;
    }
}
