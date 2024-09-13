package com.hillel.lesson_17.task;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeWordPlace {
    //5. В каждом предложении текста поменять местами первое слово с последним, не изменяя
    //длины предложения.

    private static String EX = "1 2 3 4. 2 3 4. 3 4 5. 6 7. 1";
    private static String REZ = "4 2 3 1. 4 3 2. 5 4 3. 7 6. 1";

    public static void main(String[] args) {

        System.out.println(REZ);
        System.out.println(Arrays.stream(EX.split("\\. "))
            .map(sent -> {
                String[] split = sent.split(" ");
                String word = split[0];
                split[0] = split[split.length - 1];
                split[split.length - 1] = word;
                return Arrays.stream(split).collect(Collectors.joining(" "));
            }).collect(Collectors.joining(". ")));

    }


}
