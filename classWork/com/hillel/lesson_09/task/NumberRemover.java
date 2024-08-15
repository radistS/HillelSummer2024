package com.hillel.lesson_09.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива
//(пропусков быть не должно). 1 2 3 4 5 6 4 5 4 - (4) -> 1 2 3 5 6 5
public class NumberRemover {

    public static void main(String[] args) {
        Integer[] mass = {1, 2, 3, 4, 5, 4, 5, 6, 4};
        System.out.println(Arrays.deepToString(removeNumberFromArray(mass, 5)));
    }

    public static Integer[] removeNumberFromArray(Integer[] mass, Integer value) {
        return null;
    }
}
