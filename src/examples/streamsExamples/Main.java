package com.javarush.task.Examples.streamsExamples;

import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        FileInputStream inputstream = new FileInputStream("c:/temp/text1.txt");
        long sum = 0;

        while (inputstream.available() > 0) {
            int data = inputstream.read();
            sum += data;
        }

        inputstream.close();
        System.out.println(sum);
    }
}
