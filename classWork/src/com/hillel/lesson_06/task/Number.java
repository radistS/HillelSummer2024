package com.hillel.lesson_06.task;

public class Number {
    /*
       Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
     */
    public static void main(String[] args) {
        int[] numbers = new int[10]; // 1 2 3 4 5 6 7 8 9 0

//        int value = 1254756693;
        int value = 12345;

        System.out.println(unique(value, numbers));

    }

    /*
    1 - 1254756693 -> 125475669 -> 3
    2 - 125475669 -> 12547566-> 9
    3 - 12547566 -> 1254756-> 6
    4 - 1254756 -> 125475-> 6
    ....
     */

    private static boolean unique(int value, int[] numbers) {
        while(value > 0) {
            numbers[value % 10]++;
            value /= 10;
        }
        for(int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] > 1) {
                return false;
            }
        }
       return true;
    }
}
