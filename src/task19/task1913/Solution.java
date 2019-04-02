package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultPrintStream = System.out;
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream reader = new PrintStream(byteArray);

        System.setOut(reader);
        testString.printSomething();
        String result = byteArray.toString();
        System.setOut(defaultPrintStream);

        StringBuilder str = new StringBuilder(result);

        char[] charArray = result.toCharArray();
        for (char chars :
                charArray) {
            if (chars >= '0' && chars <= '9')
                System.out.print(chars);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
