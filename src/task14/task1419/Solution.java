package com.javarush.task.task14.task1419;

import java.awt.geom.IllegalPathStateException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        try { //2
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //3
            String[] string = new String[5];
            for (int i = 0; i < string.length + 1; i++) {
                string[i] = "5";
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //4
            Object unknown = null;
            if(unknown.equals("haha")) {
                System.out.println("smth");
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //5
            String[] string = new String[-5];
            for (int i = 0; i < string.length + 1; i++) {
                string[i] = "5";
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //6
            String str = "Java Code Geeks!";


            //The following statement throws an exception, because
            //the request index is invalid.
            char ch = str.charAt(50);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try { //7
            double temp = Double.parseDouble("fds");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //8
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //9
            throw new RuntimeException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { //10
            throw new IllegalPathStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }




    }

    public static void setPercentage(int a) {

    }
}
