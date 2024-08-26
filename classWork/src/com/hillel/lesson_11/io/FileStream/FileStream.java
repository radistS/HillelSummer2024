package com.hillel.lesson_19.io.FileStream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream =
                new FileInputStream("classWork/com/hillel/lesson_11/io/FileStream/input.txt");

        int size = inputStream.available();
        System.out.println("file size : " + size);

        for (int i = 0; i < size; i++){
            System.out.print((char) inputStream.read());
        }
        inputStream.close();

        // Output stream
        OutputStream outputStream =
                new FileOutputStream("classWork/com/hillel/lesson_11/io/FileStream/out.txt");

        String str = "Stepurko Oleksandraaaa";

        outputStream.write(str.getBytes(StandardCharsets.UTF_8));

        outputStream.close();
    }
}
