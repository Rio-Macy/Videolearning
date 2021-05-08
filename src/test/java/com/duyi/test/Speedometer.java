package com.duyi.test;

public class Speedometer {

    //属性--测速器规定好的标准时间
    private int standardTime;

    public Speedometer() {
    }

    public Speedometer(int standardTime) {
        this.standardTime = standardTime;
    }

    public void seSu(Car car) {

        if (car.getSpeed() > 5) {

            PoliceCar pc = new PoliceCar(25);
            pc.chase(car);
        }
        
    }

}
