package com.duyi.test;

public class PoliceCar {

    //属性---警车自己的速度
    private int speed;

    //构造方法
    public PoliceCar(){}
    public PoliceCar(int speed){
        this.speed=speed;
    }

    public void chase(Car car) {

        int carSpeed = car.getSpeed();

        if (this.speed >= carSpeed) {

            if (this.speed - carSpeed == 0) {

                System.out.println("可以追上");
            }

            if (this.speed - carSpeed > 0) {

                int time = 100 / (this.speed - carSpeed);
                System.out.println("需要"+ time +"能够追上小汽车");
            }

        }else {

            System.out.println("小汽车飞的太快啦，望尘莫及");
        }
    }
}
