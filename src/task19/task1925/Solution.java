package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileWriter = new BufferedWriter((new FileWriter(args[1])));
            StringBuilder OutputLine = new StringBuilder("");
            while (fileReader.ready()) {

                String[] eachWord = fileReader.readLine().split(" ");
                for (String word :
                        eachWord) {
                    if (word.length() > 6)
                        OutputLine.append(word).append(",");
                }
            }
            if (OutputLine.length() > 0) {
                int length = OutputLine.length();
                OutputLine.deleteCharAt(length - 1);
                fileWriter.write(OutputLine.toString());
            }
            fileReader.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
