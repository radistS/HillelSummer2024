package com.stream.example;

import java.util.List;

public class FilterStream {

    // Знайдіть усі елементи в списку, які більше ніж 10.
    public List<Integer> allMaxTen(List<Integer> in){
        return in.stream().filter(e -> e > 10).toList();
    }

    //Відфільтруйте рядки, які містять слово "Java".
    public List<String> filterString(List<String> in){
        return in.stream().filter(e -> e.toLowerCase().contains("java")).toList();
    }

    // Знайдіть усі парні числа в списку чисел.
    public List<Integer> allOdd(List<Integer> in){
        return in.stream().filter(e -> e % 2 == 0).toList();
    }

    // Відфільтруйте всі слова, довжина яких більше 5 символів.
    public List<String> stringLengthMoreThanFive(List<String> in){
        return in.stream().filter(e -> e.length() > 5).toList();
    }

    // Знайдіть всі рядки, що починаються з літери "А".
    public List<String> stringFindAllStartWithA(List<String> in){
        return in.stream().filter(e -> e.trim().toLowerCase().startsWith("a")).toList();
    }

    // Знайдіть усі числа, менші за середнє значення списку.
    public List<Integer> filterByAverage(List<Integer> in){
        double avg = in.stream().mapToInt(Integer::intValue).average().getAsDouble();
        return in.stream().filter(e -> e < avg).toList();
    }

    public List<Integer> filterIntByAverage(List<Integer> in){
        return in.stream().filter(e -> e < in.stream().mapToInt(Integer::intValue).average().getAsDouble()).toList();
    }

}
