package com.example;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordFileProcessor {

    public static void main(String[] args) throws Exception {
        int threadCount = Runtime.getRuntime().availableProcessors(); // Количество потоков по умолчанию
        if (args.length > 1) {
            try {
                threadCount = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid thread count provided. Using default: " + threadCount);
            }
        }

        File folder = new File(args[0]); // Укажите путь к папке с текстовыми файлами

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No text files found in the directory.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<BigDecimal>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis(); // Начальное время выполнения всей программы

        for (File file : files) {
            TextFileProcessorTask task = new TextFileProcessorTask(file); // task
//            Future<BigDecimal> future = executor.submit(task);
//            futures.add(future);
        }

        for (Future<BigDecimal> future : futures) {
            System.out.println("------");
            System.out.println(future.get()); // Ожидание завершения обработки каждого файла
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis(); // Время окончания всей программы
        System.out.println("Total processing time: " + (endTime - startTime) + " ms");
    }
}
