package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //args[0] = id;   - number which is represented as String
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            BufferedInputStream fileReader = new BufferedInputStream(fileInputStream, 200);
            StringBuilder stringBuilder = new StringBuilder("");

            while (fileReader.available() > 0) {
                stringBuilder.append((char) fileReader.read());
            }
            String[] lines = stringBuilder.toString().split("\n");
            for (String strs :
                    lines) {
                if (strs.startsWith(args[0] + " ")) {
                /*if (strs.startsWith("2")) {*/
                    System.out.println(strs);
                }
            }
            reader.close();
            fileInputStream.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
