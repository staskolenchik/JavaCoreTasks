package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

/**
 * Требования:
 * 1. Считывать с консоли ничего не нужно.
 * 2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
 * 3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
 * 4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
 * 5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
 * 6. Созданные для файлов потоки должны быть закрыты.
 * */
public class Solution {
    public static void main(String[] args) {
        try {
            BufferedInputStream readFile = new BufferedInputStream(new FileInputStream(args[1]));
            BufferedOutputStream writeFile = new BufferedOutputStream(new FileOutputStream(args[2]));

            String variable = args[0];
            if ("-e".equals(variable)) {
                while (readFile.available() > 0) {
                    int charValue = readFile.read() + 5;
                    writeFile.write(charValue);
                }
            } else if ("-d".equals(variable)){
                while (readFile.available() > 0) {
                    int charValue = readFile.read() - 5;
                    writeFile.write(charValue);
                }
            }
            readFile.close();
            writeFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
