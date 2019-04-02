package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            String fullFIleName = null;
            Set<String> list = new TreeSet<>();
            boolean isFileRead = false;

            while (!"end".equals(input = bufferedReader.readLine())) {
                String[] str = input.split("[.]");
                list.add(str[str.length - 1]);//list with last element *part1-partN*
                /**
                 * determine output file name from inputFileNames;
                 * */
                StringBuilder b = new StringBuilder("");
                while (!isFileRead) {
                    isFileRead = true;
                    for (int i = 0; i < str.length - 1; i++) {
                        b.append(str[i]).append("."); //add "." and filename
                    }
                    b.trimToSize();
                    int deletInd = b.capacity();
                    b.deleteCharAt(deletInd - 1);//delete last "."
                    fullFIleName = b.toString();
                }
            }
            bufferedReader.close();

            String[] str1 = new String[list.size()];
            String[] listArr = list.toArray(str1);
            for (String string : //for each file with .partN name
                    listArr) {
                BufferedOutputStream bufferedOutputStream =
                        new BufferedOutputStream(new FileOutputStream(fullFIleName, true));
                StringBuilder builder = new StringBuilder(fullFIleName); //gather the fullName with .partN
                builder.append(".").append(string);
                BufferedInputStream bufferedInputStream =
                        new BufferedInputStream(new FileInputStream(builder.toString()));
                while (bufferedInputStream.available() > 0) { //read and write
                    int bytes = bufferedInputStream.read();
                    bufferedOutputStream.write(bytes);
                }
                bufferedInputStream.close();
                bufferedOutputStream.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
