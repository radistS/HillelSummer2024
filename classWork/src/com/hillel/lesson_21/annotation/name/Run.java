package com.hillel.lesson_21.annotation.name;

import com.hillel.lesson_21.annotation.time.MethodTimer;

public class Run {
    public static void main(String[] args) throws Exception {
        SampleClass obj = new SampleClass();
        MethodPrinter.invokeAnnotatedMethods(obj);
    }

}
