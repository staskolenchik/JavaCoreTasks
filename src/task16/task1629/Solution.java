package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();


        Read3Strings t2 = new Read3Strings();


        //add your code here - добавьте код тут

        t1.start();

        t1.join();
        t1.printResult();
        t2.start();
        t2.join();
        t2.printResult();

    }

    //add your code here - добавьте код тут

    public static class Read3Strings extends Thread {

        /*ArrayList<String> result = new ArrayList<>();
        private int count = 0;

        @Override
        public void run() {
            try {
                while (count < 3) {

                        result.add(reader.readLine());
                        count++;

                }
            } catch (IOException e) {
            }
        }

        public void printResult(){
            for(String str : result) {
                System.out.print(str + " ");
            }
            System.out.print("\n");
        }*/
        public static int count;
        public static StringBuffer str = new StringBuffer("");

        @Override
        public void run() {
            try {
                str.delete(0,str.length());
                count = 0;
                while (count < 3) {

                        str.append(reader.readLine());
                        str.append(" ");
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        public void printResult() {
            System.out.println(str);
        }
    }

}
