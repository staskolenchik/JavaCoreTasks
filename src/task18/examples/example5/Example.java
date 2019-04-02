package com.javarush.task.task18.examples.example5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Example {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream(new File("D:\\temp\\test.txt"));

        filePrintStream.println("Hello!");
        filePrintStream.println("I'm robot!");
        filePrintStream.printf("My name is %s, my age is %d! Amigo is %s", "Amigo" , 18, "BAD");

        filePrintStream.close();

    }
}
