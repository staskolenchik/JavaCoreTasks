package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = fileNameReader.readLine();
            fileNameReader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));

            while (fileReader.ready()) {
                StringBuilder stringBuilder = new StringBuilder("");
                stringBuilder.append(fileReader.readLine());
                StringBuilder strReverse = stringBuilder.reverse();
                System.out.println(strReverse.toString());
            }
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
