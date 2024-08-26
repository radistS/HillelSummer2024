package com.hillel;

import org.hillel.lib.PassGen;

public class Run {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        PassGen passGen = new PassGen();
        System.out.println(passGen.passGen(12));


    }

}
