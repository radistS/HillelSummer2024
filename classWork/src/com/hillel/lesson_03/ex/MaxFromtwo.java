package com.hillel.lesson_03.ex;

public class MaxFromtwo {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a > b){
            System.out.println(a);
        } else{
            System.out.println(b);
        }

        System.out.println((a > b) ? a : b);

        System.out.println(Math.max(a, b));
        System.out.println(Integer.max(a, b));

    }

}
