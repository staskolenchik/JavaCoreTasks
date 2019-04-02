package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileOutputStream fileWriter = new FileOutputStream(reader.readLine(), true);
            FileInputStream fileReader1 = new FileInputStream(reader.readLine());
            FileInputStream fileReader2 = new FileInputStream(reader.readLine());


            reader.close();//close
            int[] extendedCharArray1 = new int[fileReader1.available()];
            int[] extendedCharArray2 = new int[fileReader2.available()];

            int increment = 0;

            while (fileReader1.available() > 0) {
                extendedCharArray1[increment++] = fileReader1.read();
            }
            fileReader1.close();

            increment = 0;
            while (fileReader2.available() > 0) {
                extendedCharArray2[increment++] = fileReader2.read();
            }
            
            fileReader2.close();
            for (int bytes :
                    extendedCharArray1) {
                fileWriter.write(bytes);
            }
            for (int bytes :
                    extendedCharArray2) {
                fileWriter.write(bytes);
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
