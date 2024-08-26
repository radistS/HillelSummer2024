package com.hillel.lesson_12.thread;

import lombok.SneakyThrows;

public class MaxThread {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(15000);
            }
        };
        int i = 0;
        while (true){

            Thread th = new Thread(r);
            th.start();
            System.out.println(i++);
        }
    }
}
