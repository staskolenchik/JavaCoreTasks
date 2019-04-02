package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream defaultPrintStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream print = new PrintStream(outputStream);

        System.setOut(print);
        testString.printSomething();
        String result = outputStream.toString();
        StringBuilder str = new StringBuilder(result);
        while (true) {
            int index = str.indexOf("te");
            if (index < 0)
                break;
            str.deleteCharAt(index);
            str.deleteCharAt(index);
            str.insert(index, "??");
        }

        System.setOut(defaultPrintStream);
        System.out.println(str.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
