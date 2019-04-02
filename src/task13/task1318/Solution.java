package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String nameFile = reader.readLine();

            InputStream inputStream = new FileInputStream(nameFile);

            while (inputStream.available() > 0) {
                char c = (char) inputStream.read();
                System.out.print(c);
            }
            
            reader.close();
            inputStream.close();
            
        } catch (IOException e) {
            System.out.println("ошибка");
        } 
    }
}