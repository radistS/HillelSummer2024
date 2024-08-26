package com.hillel.lesson_12.thread;

public class TH implements Runnable{
    @Override
    public void run() {
        System.out.println("thread name: " + Thread.currentThread().getName());
    }
}
