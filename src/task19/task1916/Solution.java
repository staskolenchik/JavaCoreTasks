package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try {
            BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = fileNameReader.readLine();
            String fileName2 = fileNameReader.readLine();
            fileNameReader.close();
            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));

            List<String> fileLines1 = new ArrayList<>();
            List<String> fileLines2 = new ArrayList<>();
            while (fileReader1.ready()) {
                fileLines1.add(fileReader1.readLine());
            }
            fileReader1.close();
            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
            fileLines1.add("1");
            fileLines1.add("1");
            while (fileReader2.ready()) {
                fileLines2.add(fileReader2.readLine());
            }
            fileLines2.add("2");
            fileLines2.add("2");
            fileReader2.close();
            for (int i = 0; i < fileLines1.size() - 2; i++) {
                if (fileLines1.get(i).equals(fileLines2.get(i))) {
                    lines.add(new LineItem(Type.SAME, fileLines1.get(i)));
                } else if (fileLines1.get(i).equals(fileLines2.get(i + 1)) || fileLines1.get(i).equals("1")) {
                    lines.add(new LineItem(Type.ADDED, fileLines2.get(i)));
                    fileLines1.add(i,fileLines2.get(i));

                } else if (fileLines1.get(i + 1).equals(fileLines2.get(i)) || fileLines2.get(i).equals("2")) {
                    lines.add(new LineItem(Type.REMOVED, fileLines2.get(i)));
                    fileLines1.remove(i);
                    i--;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
