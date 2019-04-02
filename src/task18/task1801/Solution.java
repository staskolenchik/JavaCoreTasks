package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int maxByte = 0;
        
        while(fileInputStream.available() > 0) {
            int numByte = fileInputStream.read();
            if (maxByte < numByte) {
                maxByte = numByte;
            }
        }
        
        System.out.println(maxByte);
        
        reader.close();
        fileInputStream.close();
    }
}
