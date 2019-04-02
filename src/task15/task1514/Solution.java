package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    
    static
    {
        labels.put(1.5, "aaa");
        labels.put(1.4, "bbb");
        labels.put(1.3, "ccc");
        labels.put(1.2, "ddd");
        labels.put(1.1, "eee");
    }
}
