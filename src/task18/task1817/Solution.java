package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    private static int COUNT_CHARS;
    private static int COUNT_SPACES;

    public static void main(String[] args) {
        /*System.out.println((int) ' ');*/
        /*System.out.println((char) 97);*/
        try {
            FileInputStream readFile = new FileInputStream(args[0]);
            /*FileInputStream readFile = new FileInputStream("C:\\temp\\txt.txt");*/
            byte[] charArray = new byte[readFile.available()];
            if (readFile.available() > 0) {
                int count = readFile.read(charArray);

            }
            for (byte chars :
                    charArray) {
                if ((char) chars == ' ') {
                    COUNT_SPACES++;
                } else {
                    COUNT_CHARS++;
                }
            }
            /*double answer = (Math.round((double) COUNT_SPACES /
                    (double) (COUNT_CHARS + COUNT_SPACES) * 100.0)) * 100.0;*/
            double answer = Math.round((double) COUNT_SPACES /
                    (double) (COUNT_CHARS + COUNT_SPACES) * 10000.0) / 100.0;
            System.out.println(answer);
            readFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
