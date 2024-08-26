package com.hillel.lesson_09.ex;

public class Ex4 {
    public static void main(String[] args) {
        String s = "Hello";
        String t = new String(s);

        if ("Hello".equals(s)) System.out.println(1);
        if (t == s) System.out.println(2); // link
        if (t.equals(s)) System.out.println(3);
        if ("Hello" == s) System.out.println(4); // string pool values
        if ("Hello" == t) System.out.println(5); //
        if ("Hello" == t.intern()) System.out.println(6); // move form heap to string poll
    }
}
