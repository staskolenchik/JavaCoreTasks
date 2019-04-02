package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine(); //"D:\\temp\\text1\\txt1.txt";
            String fileName2 = reader.readLine();//"D:\\temp\\text1\\txt2.txt";
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

            StringBuilder str = new StringBuilder("");
            boolean isReady = true;
            while (isReady) {
                isReady = fileReader.ready();
                char charFile = (char) fileReader.read();
                if (charFile != ' ' && isReady)
                    str.append(charFile);
                else if (charFile == ' ' || !isReady){
                    try {
                        int a = Integer.parseInt(str.toString());
                        fileWriter.write(str.toString(), 0, str.toString().length());
                        fileWriter.write((int) ' ');
                    } catch (NumberFormatException e) {

                    }
                    int strLength = str.length();
                    str.delete(0,strLength);
                }
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
