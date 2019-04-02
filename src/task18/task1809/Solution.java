package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new BufferedReader
                (new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader
                (new InputStreamReader(System.in)).readLine());

        List<Byte> bytes = new ArrayList<>(); // bytes list
        byte[] bytesArray = new byte[1000]; //bites array
        if (fileInputStream.available() > 0) { //file has files
            //true
            int count = fileInputStream.read(bytesArray);
            for (int i = 0; i < count; i++) {
                bytes.add(bytesArray[i]);
            }
            System.out.println(bytes);
            Collections.reverse(bytes);
            for (int i = 0; i < bytes.size(); i++) {
                bytesArray[i] = bytes.get(i);
            }
            fileOutputStream.write(bytesArray, 0, count);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
