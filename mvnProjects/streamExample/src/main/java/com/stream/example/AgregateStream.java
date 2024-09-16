package com.stream.example;

import java.util.List;
import java.util.Objects;

public class AgregateStream {
    //Знайдіть кількість непарних чисел в списку.
    public long countOdd(List<Integer> in){
        return in.stream().filter(e -> e % 2 != 0).count();
    }

    // Знайдіть найбільший рядок за довжиною.
    public long maxStringLength(List<String> in){
        return in.stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2).get().length();
    }

    public long maxStringLength1(List<String> in){
        return in.stream().map(String::length).max(Integer::compareTo).orElse(0);
    }

    // Перевірте, чи є в списку порожні рядки.
    public boolean isEmptyStringExist(List<String> in){
        return in.stream().anyMatch(str -> Objects.isNull(str) || str.isEmpty());
    }

    public boolean isEmptyStringExistNull(List<String> in){
        return in.stream().filter(str -> Objects.nonNull(str)).anyMatch(str -> str.isEmpty());
    }

}
