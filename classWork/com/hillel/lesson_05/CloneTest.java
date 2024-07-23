package com.hillel.lesson_05;

public class CloneTest implements Cloneable{

    Integer i = 0;
    Pet pet;

    public CloneTest(Integer i) {
        this.i = i;
        this.pet = new Pet("Bobik", 10);
    }

    @Override
    public CloneTest clone() throws CloneNotSupportedException {
        System.out.println("run clone method");
        CloneTest ct = (CloneTest) super.clone();
        ct.pet = (Pet) pet.clone();
        return ct;
    }
}


