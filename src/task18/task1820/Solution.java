package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename1 = reader.readLine();
            String filename2 = reader.readLine();

            reader.close();

            FileInputStream fileInputStream = new FileInputStream(filename1);
            FileOutputStream fileOutputStream = new FileOutputStream(filename2, true);

            StringBuilder str = new StringBuilder("");
            char[] charArray = new char[fileInputStream.available()];
            byte[] byteArray = new byte[fileInputStream.available()];

            if (fileInputStream.available() > 0) {
                fileInputStream.read(byteArray);
            }
            fileInputStream.close();

            for (int i = 0; i < byteArray.length; i++) {
                str.append((char) byteArray[i]);
            }
            String fileString = str.toString();
            String[] strArray = fileString.split(" ");
            for (String strings :
                    strArray) {
                try {
                    Long num = Math.round(Double.parseDouble(strings));
                    char[] chArray = num.toString().toCharArray();
                    for (char ch :
                            chArray) {
                        fileOutputStream.write((int) ch);
                    }
                    fileOutputStream.write(32);
                }catch (Exception e) {
                    System.out.println("Incorrect number input");
                }
            }
            fileOutputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
