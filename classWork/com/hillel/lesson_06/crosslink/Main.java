package com.hillel.lesson_06.crosslink;

public class Main {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.setB(b);
        b.setA(a);

        C c = new C(a);

        System.out.println();
        c = null;

    }

}
