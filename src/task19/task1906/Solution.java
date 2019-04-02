package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {

    /**
     * 1. Программа должна считывать имена файлов с консоли (используй BufferedReader).+
     * 2. BufferedReader для считывания данных с консоли должен быть закрыт.+
     * 3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).+
     * 4. Поток чтения из файла (FileReader) должен быть закрыт.
     * 5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером
     * (используй FileWriter).
     * 6. Поток записи в файл (FileWriter) должен быть закрыт.
     * */
    public static void main(String[] args) {

        try {
            BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = readConsole.readLine();
            String fileName2 = readConsole.readLine();
            readConsole.close();

            FileReader reader = new FileReader(fileName1);
            FileWriter writer = new FileWriter(fileName2);
            //read each even number

            while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
            {
                int data1 = reader.read();
                //читаем один символ (char будет расширен до int)
                if (reader.ready()) {
                    int data2 = reader.read();
                    writer.write(data2); //пишем один символ (int будет обрезан/сужен до char)
                }
            }

            //закрываем потоки после использования
            reader.close();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
