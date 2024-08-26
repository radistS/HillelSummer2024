package com.hillel.lesson_09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Iterator {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        list1.add("g");

        java.util.Iterator<String> iterator = list1.iterator();

        while (iterator.hasNext()){ // check next element
//        while (true){ // check next element
            String s = iterator.next();
//            if(s.equals("b"))
//                iterator.remove();
            System.out.println(s);
        }

        System.out.println(" -------- ");

        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        java.util.Iterator<String> iterSet = set1.iterator();

        while (iterSet.hasNext()){
            String s = iterSet.next();
            System.out.println(s);
        }

    }
}
