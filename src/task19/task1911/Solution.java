package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {

    /**
     * 1. Класс Solution должен содержать класс TestString.+
     * 2. Класс Solution должен содержать публичное статическое поле testString типа TestString,
     * которое сразу проинициализировано.+
     * 3. Класс TestString должен содержать публичный void метод printSomething().+
     * 4. Метод printSomething() класса TestString должен выводить на экран строку "it's a text for
     * testing".+
     * 5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй
     * PrintStream c конструктором принимающим ByteArrayOutputStream).
     * 6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в
     * консоль объекта System.out.
     * 7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
     * 8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом
     * printSomething() согласно заданию, и выводить её в консоль.
     * */
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleprintStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();
        String result = outputStream.toString();
        String newResult = result.toUpperCase();

        System.setOut(consoleprintStream);
        System.out.println(newResult);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
