package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Считаем слово
 * Считать с консоли имя файла.
 * Файл содержит слова, разделенные знаками препинания.
 * Вывести в консоль количество слов "world", которые встречаются в файле.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли (используй BufferedReader).+
 * 2. BufferedReader для считывания данных с консоли должен быть закрыт.+
 * 3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).+
 * 4. Поток чтения из файла (FileReader) должен быть закрыт.+
 * 5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
 * */
public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            int countWorld = 0;
            FileReader fileReader = new FileReader(fileName);
            StringBuilder wordWorld = new StringBuilder("");
            while (fileReader.ready()) {
                int character = fileReader.read();
                if (character == ' ' || (character >= 'a' && character <= 'z')) {
                    wordWorld.append((char) character);
                    if (wordWorld.length() == 6 && " world".equals(wordWorld.toString())) {
                        countWorld++;
                        int cap = wordWorld.length();
                        wordWorld.delete(0, cap);
                    }
                } else if (character < ' ' || (character > ' ' && character < 'a') || character > 'z') {
                    int cap = wordWorld.length();
                    wordWorld.delete(0, cap);

                }
            }

            System.out.println(countWorld);
            fileReader.close();

            /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            int countWorld = 0;
            FileReader fileReader = new FileReader(fileName);
            while (fileReader.ready()) {
                int i = fileReader.read();
                if (i == 'w' && fileReader.ready()) {
                    int u = fileReader.read();
                    if (u == 'o' && fileReader.ready()) {
                        int y = fileReader.read();
                        if (y == 'r' && fileReader.ready()) {
                            int t = fileReader.read();
                            if (t == 'l' && fileReader.ready()) {
                                int r = fileReader.read();
                                if (r == 'd' && fileReader.ready()) {
                                    countWorld++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(countWorld);
            fileReader.close();*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
