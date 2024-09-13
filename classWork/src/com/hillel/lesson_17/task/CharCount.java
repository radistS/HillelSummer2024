package com.hillel.lesson_17.task;

/*
Фильтрация и подсчет символов:
Создай поток из списка строк.
Оставь только те строки, длина которых больше 5 символов, и подсчитай общее количество символов в этих строках.
 */

import java.util.Arrays;
import java.util.List;

public class CharCount {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "grape", "watermelon", "kiwi", "orange");

        int sum = strings.stream()
            .filter(s -> s.length() > 5)
            .mapToInt(String::length)
            .sum();


        System.out.println(sum);


        List<String> string = Arrays.asList("apples", "bananas", "grape", "watermelons", "kiwi", "oranges");

        System.out.println(string.stream().filter(s -> s.endsWith("s")).count());

        int count =0;

        for (String s : string) {
            if (s.endsWith("s")) {
                count++;
            }
        }
        System.out.println(count);


    }

}
