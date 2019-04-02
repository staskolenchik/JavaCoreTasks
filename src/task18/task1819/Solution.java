package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();

            reader.close();
            /**
             * read bytes from the first file
             * */
            FileInputStream fileInputStream1 = new FileInputStream(filename1);
            byte[] bytesFile1 = new byte[1000];

            int file1Size = fileInputStream1.available();
            if (fileInputStream1.available() > 0) {
                fileInputStream1.read(bytesFile1, 0, file1Size);
            }
            fileInputStream1.close();

            FileOutputStream fileOutputStream = new FileOutputStream(filename1);
            FileInputStream fileInputStream2 = new FileInputStream(filename2);

            int file2Size = fileInputStream2.available();

            if (fileInputStream2.available() > 0) {
                fileInputStream2.read(bytesFile1, file1Size, file2Size);
            }


            fileOutputStream.write(bytesFile1, file1Size, file2Size);
            fileOutputStream.write(bytesFile1, 0, file1Size);

            fileInputStream2.close();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
