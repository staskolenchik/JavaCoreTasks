package com.javarush.task.task18.task1802;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        FileInputStream fInpStr = new FileInputStream(reader.readLine());

        List<Integer> listBytes = new ArrayList<>();
        
        while(fInpStr.available() > 0) {
            int numByte = fInpStr.read();
            listBytes.add(numByte);
        }
        int minByte = listBytes.get(0);

        for (Integer integ :
                listBytes) {
            if(integ < minByte)
                minByte = integ;
        }

        System.out.println(minByte);
        
        reader.close();
        fInpStr.close();
    }
}
