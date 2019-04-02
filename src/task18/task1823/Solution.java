package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while(!"exit".equals(s = fileNameReader.readLine())) {
                new ReadThread(s).start();


            }
            /*System.out.println(resultMap);*/
            fileNameReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private static String fileNameCopy;
        public ReadThread(String fileName) {
            //implement constructor body
            fileNameCopy = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                BufferedInputStream bufferedInputStream =
                        new BufferedInputStream(new FileInputStream(fileNameCopy));
                int[] byteArray = new int[bufferedInputStream.available()];
                for (int i = 0; bufferedInputStream.available() > 0; i++) {
                    byteArray[i] = bufferedInputStream.read();
                }
                int countMax = 0;
                int indexMax = 0;
                for (int i = 0; i < 256; i++) {
                    int count = 0;
                    for (int j = 0; j < byteArray.length; j++) {
                        if (i == byteArray[j])
                            count++;
                    }
                    //add to resultMap as key Character as value a count
                    if (count > countMax) {
                        countMax = count;
                        indexMax = i;
                    }
                }

                Solution.resultMap.put(fileNameCopy, indexMax);

                bufferedInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
