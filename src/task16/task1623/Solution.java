package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.print(new GenerateThread());
    }

    public static class GenerateThread extends Thread {


        public GenerateThread() {
            super(++Solution.createdThreadCount + "");
            start();
        }

        @Override
        public void run() {
            if (Solution.createdThreadCount < Solution.count) {
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return super.getName() + " created";
        }
    }
}
