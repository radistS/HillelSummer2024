package com.stream.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapStream {

    //Перетворіть список рядків в список їхніх довжин.
    public List<Integer> mapStringToLength(List<String> in){
        return in.stream().map(String::length).toList();
    }

    // Створіть список унікальних символів з кожного рядка списку.
    List<String> uniqueChar(List<String> in){
        return in.stream()
            .map(str -> Arrays.stream(str.split(""))
                .distinct()
                .sorted()
                .collect(Collectors.joining())
            ).toList();
    }

    // Створіть список об'єктів, змінюючи певне поле.
    List<Person> updatePersonInformationPeek(List<Person> persons){
        return persons.stream().peek(p -> p.setEmail(p.getName() + "@mail.com")).toList();
    }

    List<Person> updatePersonInformationMap(List<Person> persons){
        return persons.stream()
            .map(p -> {
                p.setEmail(p.getName() + "@mail.com");
                return p;
            })
            .toList();
    }

}
