package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread testThread = new TestThread();
        testThread.start();
        Thread.sleep(3500);
        testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        public static int i = 0;
        @Override
        public void run() {
            while(!isInterrupted() && i < 10) {
                try {
                    Thread.sleep(1000);
                    System.out.println("testThread runs! " + ++i + " seconds");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("testThread was interrupted!");
                }
            }
        }
    }
}