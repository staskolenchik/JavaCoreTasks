package com.javarush.task.task18.examples.example4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Example4 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream(new File("D:\\temp\\test.txt"));

        filePrintStream.println(222);
        filePrintStream.println("Hello World");
        filePrintStream.println(false);
    }
}
