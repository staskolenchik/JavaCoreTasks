package com.javarush.task.task16.task1611;

/* 
Часы
*/

public class Solution {
    public static volatile boolean isStopped = false;//1

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();//2
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("The clock has to be stopped");
        Thread.sleep(2000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {
        public Clock() {
            setPriority(MAX_PRIORITY);//3
            start();//4
        }

        public void run() {//5
            try {
                while (!isStopped) {//6 //runs true
                    printTikTak(); //7
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException { //8
            //add your code here - добавь код тут
            System.out.println("Tik");//9
            Thread.sleep(500);//10
            System.out.println("Tak");//11
            Thread.sleep(500); //12
            isStopped = true;
        }
    }
}
