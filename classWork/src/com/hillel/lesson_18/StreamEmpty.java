package com.hillel.lesson_18;

import java.util.List;

public class StreamEmpty {

    public static void main(String[] args) {
//        List<Integer> inList = List.of();
        List<Integer> inList = List.of(1, 10, 100);

        List<Integer> out = inList.stream().filter(i -> i < 10).toList();

        System.out.println(out);
    }

}
