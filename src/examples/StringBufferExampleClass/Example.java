package com.javarush.task.examples.StringBufferExampleClass;

public class Example {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("501234567");
        while (str.length() < 10) {
            str.insert(0, 0);
        }
        str.insert(0, "(")
                .insert(4, ")")
                .insert(8, "-")
                .insert(11, "-");


    }
}
