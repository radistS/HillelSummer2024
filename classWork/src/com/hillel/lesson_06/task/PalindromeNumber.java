package com.hillel.lesson_06.task;
//        Given an integer x, return true if x is a palindrome, and false otherwise.
//
//        Example 1:
//        Input: x = 121
//        Output: true
//        Explanation: 121 reads as 121 from left to right and from right to left.

//        Example 2:
//        Input: x = -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

//        Example 3:
//        Input: x = 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


public class PalindromeNumber {

    public static void main(String[] args) {

        Integer number = 12121;
        String str = String.valueOf(number);
        String strRev = new StringBuilder(str).reverse().toString();
        System.out.println(str.equals(strRev));
    }

    public static boolean isPalindrome(int x) {
        // Отрицательные числа и числа, оканчивающиеся на 0 (кроме 0) не могут быть палиндромами
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Реверсируем число
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        // Сравниваем исходное число и реверсированное
        return original == reversed;
    }

    public static boolean isPalindromeLoop(int x) {
        // Отрицательные числа не являются палиндромами
        if (x < 0) {
            return false;
        }

        // Преобразуем число в строку
        String numStr = Integer.toString(x);
        int len = numStr.length();

        // Сравниваем символы с начала и конца строки
        for (int i = 0; i < len / 2; i++) {
            if (numStr.charAt(i) != numStr.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
