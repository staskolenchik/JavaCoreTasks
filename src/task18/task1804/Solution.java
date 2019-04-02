package com.javarush.task.task18.task1804;

import sun.text.resources.el.CollationData_el;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        Map<Integer, Integer> countByteNum = new HashMap<>();
        List<Integer> listBytes = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            listBytes.add(fileInputStream.read());
        }

        Collections.sort(listBytes);
        int countMins = 1;

        for (int i = 0; i < listBytes.size(); i++) {
            try {
                if (listBytes.get(i) == listBytes.get(i + 1)) {
                    listBytes.remove(i + 1);
                    i--;
                    countMins++;
                } else {
                    countByteNum.put(listBytes.get(i), countMins);
                    countMins = 1;
                }
            } catch (Exception e) {
                countByteNum.put(listBytes.get(i), countMins);
                countMins = 1;
            }
        }


        int maxIterations = 0;
        for (int i = 0; i < listBytes.size(); i++) {
            if (countByteNum.get(listBytes.get(i)) > maxIterations) {
                maxIterations = countByteNum.get(listBytes.get(i)); //get max number of iterations
            }
        }

        int minIterations = maxIterations; //start point for min number of iterations
        for (int i = 0; i < listBytes.size(); i++) {
            if (countByteNum.get(listBytes.get(i)) < minIterations) {
                minIterations = countByteNum.get(listBytes.get(i)); //get min number of iterations
            }
        }

        Set<Integer> keySet= countByteNum.keySet();
        Iterator<Integer> it = keySet.iterator();
        /*System.out.println(countByteNum); ///test*/
        while (it.hasNext()) {
            int next = it.next();
            if (countByteNum.get(next) == minIterations) {

                System.out.print(next + " ");
            }
        }

        reader.close();
        fileInputStream.close();

    }
}
