package com.hillel.lesson_27.ex;

public class ex3 {
    public static void main(String [] args) {
        int i = 2 ;
        boolean res = false ;
        res = i++ == 2 | --i == 2 & --i == 2 ;
        // true | true & false


        System. out .println(i);
        System. out .println(res);
    }
}


