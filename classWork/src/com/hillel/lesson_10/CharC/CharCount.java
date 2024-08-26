package com.hillel.lesson_10.CharC;

import java.util.HashMap;

public class CharCount {

    public static void main(String[] args) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String s : Text.getText().toLowerCase().split("")){
            result.put(s, result.getOrDefault(s, 0) + 1);
        }

        System.out.println(result);
    }


}
