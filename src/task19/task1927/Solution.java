package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try {
            PrintStream defaultOut = System.out;
            //object, were every println is stored;
            ByteArrayOutputStream lineSystem = new ByteArrayOutputStream();
            //new object wraper, where new object is stored
            PrintStream contextAdvertising = new PrintStream(lineSystem);
            //set variable out not as default (console) but an our new object
            System.setOut(contextAdvertising);
            //invoke println


            testString.printSomething();
            System.setOut(defaultOut);
            StringBuilder builder = new StringBuilder("");
            String[] eachLine = lineSystem.toString().split("\n");
            for (int i = 0; i < eachLine.length; i++) {
                if (i % 2 == 0 && i != 0)
                    builder.append("JavaRush - курсы Java онлайн").append("\n");
                builder.append(eachLine[i]).append("\n");
            }
            System.out.print(builder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
