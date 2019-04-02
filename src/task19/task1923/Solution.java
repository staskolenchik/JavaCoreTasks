package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            StringBuilder stringBuilder = new StringBuilder("");
            while (reader.ready()) {
                String[] eachWord = reader.readLine().split(" ");
                for (String word :
                        eachWord) {
                    char[] charsWord = word.toCharArray();
                    for (char chars:
                         charsWord) {
                        if (chars == '0' || chars == '1' || chars == '2' || chars == '3' ||
                                chars == '4' || chars == '5' || chars == '6' || chars == '7' ||
                                chars == '8' || chars == '9')
                            stringBuilder.append(word).append(" ");
                        break;
                    }
                }
            }
            writer.write(stringBuilder.toString());
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
