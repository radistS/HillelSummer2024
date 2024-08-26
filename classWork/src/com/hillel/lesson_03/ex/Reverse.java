package com.hillel.lesson_03.ex;


// reverse number 111112344 - 443211111
public class Reverse {
    public static void main(String[] args) {

        System.out.println(reverse(12546));
    }

    private static int reverse(int value){
        String str = Integer.toString(value);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return Integer.parseInt(reversed);
    }
}
