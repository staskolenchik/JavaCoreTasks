package com.javarush.task.task16.task1633;

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler(); //our handler

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler); //set UEH and starts thread1

        Thread threadA = new Thread(commonThread, "Нить 1"); //same thing as thread1, but has name Нить 1
        Thread threadB = new Thread(commonThread, "Нить 2");//same thing as thread1, but has name Нить 2

        threadA.start();
        threadB.start();

        
        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {

            start();
        }

        public void run() {
            try {
                currentThread().setUncaughtExceptionHandler(handler);//set in the this object handler
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) { //prints Thread name and message of exception
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
