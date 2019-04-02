package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    private static int COUNT_ENG_CHAR = 0;
    public static void main(String[] args) {
            try {
            /*File file = new File("C:\\temp\\txt.txt");*/
            FileInputStream reader = new FileInputStream(args[0]);
            byte[] bytes = new byte[1000];
            int count = 0;
            if (reader.available() > 0) {
                count = reader.read(bytes);
            }
            for (int i = 0; i < count; i++) {
                if (((char) bytes[i] >= 'a' && (char) bytes[i] <= 'z') ||
                        ((char) bytes[i] >= 'A' && (char) bytes[i] <= 'Z')) {
                    COUNT_ENG_CHAR++;
                }
            }
            System.out.println(COUNT_ENG_CHAR);
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
