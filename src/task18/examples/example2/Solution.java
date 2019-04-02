package com.javarush.task.task18.examples.example2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\temp\\test.txt");

        int i;

        while((i=fileInputStream.read())!= -1){

            System.out.print((char)i);
        }
    }
}
