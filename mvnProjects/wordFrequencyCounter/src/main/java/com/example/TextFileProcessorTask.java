package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class TextFileProcessorTask implements Callable<Void> {
    private final File file;

    public TextFileProcessorTask(File file) {
        this.file = file;
    }

    @Override
    public Void call() throws Exception {
        long startTime = System.currentTimeMillis();
        int wordCount = countWords(file);
        long endTime = System.currentTimeMillis();

        System.out.println("Thread " + Thread.currentThread().getName() +
                " processed file: " + file.getName() +
                " | Size: " + (file.length() / 1024) + " KB" +
                " | Words: " + wordCount +
                " | Processing time: " + (endTime - startTime) + " ms");

        return null;
    }

    private int countWords(File file) throws IOException {
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }
}
