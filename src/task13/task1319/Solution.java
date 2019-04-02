package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String nameFile = reader.readLine();


            BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile));

            while (true) {

                String dataStr = reader.readLine() ;

                writer.write(dataStr);
                writer.newLine();
                if (dataStr.equals("exit")) {
                    break;
                }


            }
            writer.close();
            reader.close();


        } catch (IOException e) {
            System.out.println("Оишбка");
        }
    }
}
