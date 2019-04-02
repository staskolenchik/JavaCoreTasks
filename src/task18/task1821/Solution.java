package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {

            /*BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));*//*
            FileInputStream fileInputStream = new FileInputStream(reader2.readLine());*/
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            BufferedInputStream reader = new BufferedInputStream(fileInputStream, 200);
            List<Integer> bytesList = new ArrayList<>();

            while (reader.available() > 0) {
                bytesList.add(reader.read()); //fill bytesList
            }

            Collections.sort(bytesList);

            for (int i = 0; i < 256; i++) {
                int count = 0;
                for (int j = 0; j < bytesList.size(); j++) {
                    if (i == bytesList.get(j))
                        count++;
                }
                if (count > 0)
                    System.out.println((char) i + " " + count);
            }

            fileInputStream.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
