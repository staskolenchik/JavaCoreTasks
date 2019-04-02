package com.javarush.task.task18.examples.example7;

public class Example {
    public static void main(String[] args) {
        double a = -3.51;
        Long longer = 125L;
        char[] chars = longer.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        //4
        System.out.println();
    }
}
