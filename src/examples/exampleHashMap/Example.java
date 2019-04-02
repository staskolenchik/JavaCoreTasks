package com.javarush.task.examples.exampleHashMap;

import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Map<String, Double> data = new HashMap<>();
        data.put("one", 1.0);
        data.put("two", 2.0);
        data.put("three", 3.0);

        //get key by value
        double maxValue = 0.0;
        String maxValueKey = null;
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            if (maxValue < entry.getValue()) {
                maxValue = entry.getValue();
                maxValueKey = entry.getKey();
            }
        }
        System.out.println(maxValueKey);

    }
}
