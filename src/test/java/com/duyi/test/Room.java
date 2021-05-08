package com.duyi.test;

public class Room {

    private static Computer[] computer = new Computer[5];
    private Integer useStatueNum = 4;

    static {
        for (int i = 0; i < computer.length; i++) {

            computer[i] = new Computer();
        }
    }

    public Room() {
    }

//    public void setComputer(Computer[] computer) {
//        this.computer = computer;
//    }
//
//    public Computer[] getComputer() {
//        return computer;
//    }

    public void leaning(Student student) {

        System.out.println("学生" + student.getName() + "进入机房...");

        for (int i = 0; i < computer.length; i++) {

            if (useStatueNum == -1) {

                System.out.println("没有闲置的电脑...");
                break;
            }
            if (computer[i].isStatus() != true & useStatueNum != -1) {

                student.useComputer(computer[i]);
                useStatueNum -= 1;

                break;
            }

        }
    }

    public void freeComputer() {


    }
}
