package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader filePathReader = new BufferedReader(new InputStreamReader(System.in));
            String filePath;
            while (!"exit".equals(filePath = filePathReader.readLine())) {
                try {
                    BufferedInputStream bufferedInputStream =
                            new BufferedInputStream(new FileInputStream(filePath));

                    bufferedInputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(filePath);
                    filePathReader.close();
                    return;
                }
            }
            filePathReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
