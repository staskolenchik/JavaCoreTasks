package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        List<Integer> listBytes = new ArrayList<>();
        List<Integer> iterations = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            listBytes.add(fileInputStream.read());
        }
        reader.close();
        fileInputStream.close();

        Collections.sort(listBytes);
        { //fill iterations list with counted listBytes's elements
            int countIterions = 1;
            for (int i = 0; i < listBytes.size() - 1; i++) {
                if (listBytes.get(i) == listBytes.get(i + 1)) {
                    countIterions++;
                    listBytes.remove(i + 1);
                    i--;
                } else {
                    iterations.add(countIterions);
                    countIterions = 1;
                }
            }
            iterations.add(countIterions);
        }

        { //find max number of iterations
            int maxNum = 1;
            for (Integer maxN :
                    iterations) {
                if (maxN > maxNum)
                    maxNum = maxN;
            }

            for (int i = 0; i < iterations.size(); i++) {
                if (maxNum == iterations.get(i))
                    System.out.print(listBytes.get(i) + " ");
            }
        }


    }
}
