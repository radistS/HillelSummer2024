package com.hillel.lesson_05.interfaces;

public interface SayHello extends Say{
    @Override
    default void sayHello(){
        System.out.println("say default sayHello ...");
    };
}
