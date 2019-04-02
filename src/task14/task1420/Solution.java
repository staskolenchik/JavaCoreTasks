package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        List<Integer> list = new ArrayList<>();

        while (true) {
            try {

                Integer a = Integer.parseInt(reader.readLine());

                if (a < 1) {
                    throw new Exception();
                } else {
                    list.add(a);
                }
                if (list.size() == 2) {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Input correct positive number");
            }

        }

        reader.close();

        System.out.println(Solution.findNOD(list.get(0), list.get(1)));

    }

    public static int findNOD(Integer a, Integer b) {

        int aCount2 = 0;
        int bCount2 = 0;

        int aCount3 = 0;
        int bCount3 = 0;

        int aCount5 = 0;
        int bCount5 = 0;

        int aCount7 = 0;
        int bCount7 = 0;

        while (a % 2 == 0) {
            a = a / 2;
            aCount2++;
        }
        while (a % 3 == 0) {
            a = a / 3;
            aCount3++;
        }
        while (a % 5 == 0) {
            a = a / 5;
            aCount5++;
        }
        while (a % 7 == 0) {
            a = a / 7;
            aCount7++;
        }

        while (b % 2 == 0) {
            b = b / 2;
            bCount2++;
        }
        while (b % 3 == 0) {
            b = b / 3;
            bCount3++;
        }
        while (b % 5 == 0) {
            b = b / 5;
            bCount5++;
        }
        while (b % 7 == 0) {
            b = b / 7;
            bCount7++;
        }
        int count2 = 1;
        int count3 = 1;
        int count5 = 1;
        int count7 = 1;

        if (aCount2 >= bCount2) {
            count2 = (int) (Math.pow(2, bCount2));
        } if (aCount2 < bCount2){
            count2 = (int) (Math.pow(2, aCount2));
        }  if (aCount3 >= bCount3) {
            count3 = (int) (Math.pow(3, bCount3));
        }  if (aCount3 < bCount3){
            count3 = (int) (Math.pow(3, aCount3));
        }  if (aCount5 >= bCount5) {
            count5 = (int) (Math.pow(5, bCount5));
        }  if (aCount5 < bCount5){
            count5 = (int) (Math.pow(5, aCount5));
        }  if (aCount7 >= bCount7) {
            count7 = (int) (Math.pow(7, bCount7));
        }  if (aCount7 < bCount7){
            count7 = (int) (Math.pow(7, aCount7));
        }
        return count2*count3*count5*count7;
    }
}
