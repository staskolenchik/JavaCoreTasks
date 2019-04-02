package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import org.omg.IOP.Encoding;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
* 1. Программа НЕ должна считывать данные с консоли.
 * 2. Программа должна считывать содержимое файла (используй FileReader).
 * 3. Поток чтения из файла (FileReader) должен быть закрыт.
 * 4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть
 * отсортированы в возрастающем порядке по имени.
* */

public class Solution {
    public static void main(String[] args) {
        try {
            Map<String, Double> data = new TreeMap<>();
            FileReader fileReader = new FileReader(args[0]);
            /*BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0]), Charset.forName("Cp1251")));*/
            //Charset.forName("Cp1251") set CharsetDecoder for reading chars that are contain more than 2 bytes
            //read file into string array for each line
            StringBuilder fileAsString = new StringBuilder("");
            while (fileReader.ready()) {
                int eachByte = fileReader.read();
                fileAsString.append((char) eachByte);
            }
            fileReader.close();
            String[] eachLineAsString = fileAsString.toString().split("\r\n");
            //put name and salaryCount into  TreeMap<String, Double> collection
            for (int i = 0; i < eachLineAsString.length; i++) {
                StringBuilder strKey = new StringBuilder("");
                char[] charArrayLine = eachLineAsString[i].toCharArray();
                for (int k = 0; k < charArrayLine.length; k++) {
                    if (charArrayLine[k] == ' ') {
                        StringBuilder strValue = new StringBuilder("");
                        for (int j = k + 1; j < charArrayLine.length; j++) {
                            if (charArrayLine[j] != '\r' || charArrayLine[j] != '\n')
                                strValue.append(charArrayLine[j]);
                        }
                        Double DoubleValue = Double.parseDouble(strValue.toString());
                        if (data.containsKey(strKey.toString())) {
                            double sum = data.get(strKey.toString()) + DoubleValue;
                            data.put(strKey.toString(), sum);
                            break;
                        } else {
                            data.put(strKey.toString(), DoubleValue);
                            break;
                        }

                    }
                    strKey.append(charArrayLine[k]);
                }
            }

            //display data in console
            Set<String> keySet = new TreeSet<>();
            keySet = data.keySet();
            for (String key :
                    keySet) {
                System.out.println(key + " " + data.get(key));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
