package com.hillel.lesson_03.ex;

// count sum of odd numbers 12235 - 1 + 3 + 5 = 9
public class ChetNumber {

    public static void main(String[] args) {
        int number = 123;
        System.out.println(calculate(number));
    }

    private static int calculate(int value){
        int rez = 0;
        while (value != 0) {
            int mod = value % 10;
            if (mod % 2 ==1) {
                rez += mod;
            }
            value /= 10;
        }

        return rez;
    }

/*
1 -> 3 -> 3 % 2 = 1 - rez = 3 -> 12
2 -> 2 -> 2 % 2 = 0 - rez = 3 -> 1
3 -> 1 -> 1 % 2 = 1 - rez = 2 -> 0
 */
}
