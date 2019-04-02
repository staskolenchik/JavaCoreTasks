package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            Map<String, Double> data = new TreeMap<>();
            label1:
            while (fileReader.ready()) {
                String[] partLine = fileReader.readLine().split(" ");
                if (partLine[1].contains("\r\n")) {
                    int index = partLine[1].indexOf("\r\n");
                    partLine[1] = partLine[1].substring(0, index);
                }
                for (Map.Entry<String, Double> pair :
                        data.entrySet()) {
                    if (pair.getKey().equals(partLine[0])) {
                        pair.setValue(pair.getValue() + Double.parseDouble(partLine[1]));
                        continue label1;
                    }
                }
                data.put(partLine[0], Double.parseDouble(partLine[1]));
            }
            fileReader.close();
            //find the max value
            double maxValue = 0.0;
            Set<String> maxKeySet = new TreeSet<>();
            String maxValueKey = null;
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                if (maxValue < entry.getValue()) {
                    maxValue = entry.getValue();
                    maxValueKey = entry.getKey();
                }
            }
            maxKeySet.add(maxValueKey);
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                if (maxValue == entry.getValue()) {
                    maxKeySet.add(entry.getKey());
                }
            }
            for (String aMaxKeySet : maxKeySet) {
                System.out.println(aMaxKeySet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
