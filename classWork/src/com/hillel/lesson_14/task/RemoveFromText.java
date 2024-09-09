package com.hillel.lesson_14.task;


import java.util.Arrays;

// Из текста удалить все слова заданной длины, начинающиеся c заданой буквы.
public class RemoveFromText {

    private final static String TEXT = "Скажите зачем эта маленькая княгиня сказал знязь Василий " +
            "зтихо Анне Павловне почему он особенно умного Мы зосле поговорим сказала Анна Павловна" +
            " улыбаясь";

    public static void main(String[] args) {
        String l = "с";
        Integer i = 4;
//        Arrays.stream(TEXT.split(" "))
//            .filter(s -> s.length() != i && !s.toLowerCase().startsWith(l))
//            .forEach(System.out::println);

        Arrays.stream("c cc cccc c саша".split(" "))
            .filter(s -> s.length() != i && !s.toLowerCase().startsWith(l))
            .forEach(System.out::println);


    }
}
