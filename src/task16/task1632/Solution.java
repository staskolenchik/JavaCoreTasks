package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static
    {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }
    public static void main(String[] args) {
        for (Thread thr :
                threads) {
            thr.start();
        }
    }

    public static class Thread1 extends Thread {
        private static int a = 0;
        @Override
        public void run() {
            while (a == 0) {

            }
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            try {
                if (Thread.interrupted())
                    throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                return;
                }
            }
        }


    public static class Thread3 extends Thread {

        @Override
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        private static boolean isRunning = false;

        @Override
        public void showWarning() {
            isRunning = true;
        }

        @Override
        public void run() {
            while(!isRunning) {

            }
        }
    }

    public static class Thread5 extends Thread {
        private static Scanner sc = new Scanner(System.in);
        private static String s;

        @Override
        public void run() {
            int num = 0;
            while (!"N".equals(s = sc.nextLine())) {
                 num += Integer.parseInt(s);

            }
            System.out.println(num);
        }
    }


}