package com.hillel.lesson_09.coll;

import java.util.LinkedList;
import java.util.List;

public class LL {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println(list.size());
//        ((LinkedList<String>) list).removeFirst();
//        ((LinkedList<String>) list).removeLast();
        list.add("swww1");
        list.add("swww2");
        list.add("swww3");
        list.add(1,"sww1_1");

        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());


    }
}
