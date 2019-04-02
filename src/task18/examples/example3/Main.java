package com.javarush.task.task18.examples.example3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\temp\\test.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 50);

        /*while (fileInputStream.available() > 0) {
            System.out.print((char) fileInputStream.read());
        }*/
        int i= -1;

        while((i = bufferedInputStream.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
