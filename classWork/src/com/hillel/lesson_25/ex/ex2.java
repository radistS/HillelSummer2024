package com.hillel.lesson_27.ex;

public class ex2 {
    public static void main(String[] args) {
        boolean flag = false;
        System.out.println(
                (flag = true) | (flag = false) || (flag = true));
    }
}
