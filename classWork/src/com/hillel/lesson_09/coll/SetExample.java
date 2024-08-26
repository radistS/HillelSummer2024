package com.hillel.lesson_09.coll;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class SetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        System.out.println(set.add("012A"));
        System.out.println(set.add("Bsad"));
        System.out.println(set.add("123edsC"));
        System.out.println(set.add("dsdD"));

        System.out.println(set.add("A"));

        System.out.println(set);

        Set<TestSetColl> set1 = new HashSet<>();

        TestSetColl t1 = new TestSetColl(1, 1);
        TestSetColl t2 = new TestSetColl(1, 1);

        System.out.println(set1.add(t1));
        System.out.println(set1.add(t2));

        Vector<String> vector = new Vector<>();

    }

}
