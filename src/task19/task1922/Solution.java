package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }
    /*static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }*/
        //1. each line add into StringBuilder
    //2. each char compare to list words, if true -> count++
    //3. if count == 2 -> sout line;
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while (fileReader.ready()) {
                String eachLine = fileReader.readLine();
                String[] eachWord = eachLine.split(" ");
                int countSameWords = 0;
                for (String word :
                        eachWord) {
                    for (String wordsArray :
                            words) {
                        if (wordsArray.equals(word))
                            countSameWords++;
                    }
                }
                if (countSameWords == 2) {
                    System.out.println(eachLine);
                }
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
