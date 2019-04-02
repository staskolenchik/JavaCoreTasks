package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
   public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream3 = new FileOutputStream(reader.readLine());

        byte [] byteBlock1 = new byte[1000];

        if (fileInputStream1.available() > 0) { //if file has bytes
            if ((fileInputStream1.available() % 2) == 1) { //if odd number of bytes
                int count1 = fileInputStream1.read(byteBlock1, 0,
                        (fileInputStream1.available() / 2) + 1); //
                fileOutputStream2.write(byteBlock1, 0, count1);
                fileOutputStream2.close();
                int count2 = fileInputStream1.read(byteBlock1,
                        fileInputStream1.available() + 1, fileInputStream1.available());
                fileInputStream1.close();
                fileOutputStream3.write(byteBlock1, count2 + 1, count2);
                fileOutputStream3.close();
            } else {
                int count1 = fileInputStream1.read(byteBlock1, 0,
                        fileInputStream1.available() / 2);
                fileOutputStream2.write(byteBlock1, 0, count1);
                fileOutputStream2.close();
                int count2 = fileInputStream1.read(byteBlock1,
                        fileInputStream1.available(), fileInputStream1.available());
                fileInputStream1.close();
                fileOutputStream3.write(byteBlock1, count2, count2);
                fileOutputStream3.close();
            }
        }
        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();

    }
}
