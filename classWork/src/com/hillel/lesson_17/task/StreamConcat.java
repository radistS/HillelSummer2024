package com.hillel.lesson_17.task;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcat {
    public static void main(String[] args) {

        Stream<Integer> str1 = Stream.of(1, 2, 3);
        Stream<Integer> str2 = Stream.of( 3, 4, 5);
        Stream<Integer> str3 = Stream.of( 5, 6, 7);
        Stream<Integer> str4 = Stream.of( 7, 8, 9);

        Stream<Integer> concat1 = Stream.concat(str1, str2);
        Stream<Integer> concat2 = Stream.concat(str3, str4);

        Stream<Integer> concat3 = Stream.concat(concat1, concat2);

        System.out.println(concat3.collect(Collectors.toSet()));
    }

}
