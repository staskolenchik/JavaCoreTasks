package com.javarush.task.task18.examples.example1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Soletuion {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\temp\\t5.txt", true);
        String greetings = "Привет! Добро пожаловать на JavaRush - лучший сайт для тех, кто хочет стать программистом!\r\n";
        fileOutputStream.write(greetings.getBytes());
        fileOutputStream.close();

    }
}
