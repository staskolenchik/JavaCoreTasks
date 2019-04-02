package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock(); //thread clock
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
        if (clock.isInterrupted()) {
            System.out.println("Прервано!");
        }

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start(); //starts thread of current object
        }

        public void run() {
            //add your code here - добавь код тут
            while (!isInterrupted() && numSeconds > 0) {
                System.out.print(numSeconds-- + " ");
                try {
                    Thread.sleep(1000);
                    if (numSeconds == 0)
                        System.out.print("Марш!");
                    } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
    }
}
