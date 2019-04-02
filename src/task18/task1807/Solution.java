package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int readByte = fileInputStream.read();
            if ((char) readByte == ',')
                arrayList.add(readByte);
        }
        System.out.println(arrayList.size());

        reader.close();
        fileInputStream.close();
    }
}
