package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    private String s;
    private int a;
    private double b;

    public static void main(String[] args) {

    }

    private Solution(){}

    Solution(int a){}

    protected Solution(String s){}

    public Solution(double b){}

}

