package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = null;



        try {
            while(true) {
                s = reader.readLine();
                boolean b = false;

                if ("exit".equals(s)) { //1
                    break;
                }

                try {
                    Double doub = Double.parseDouble(s);
                    char[] chars = s.toCharArray(); //2.1
                    for (char ch :
                            chars) {
                        if (ch == '.') {
                            b = true;
                        }
                    }
                    if (b) {
                        print(doub);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception p) {
                    try { //2.2
                        short sh = Short.parseShort(s);
                        if (sh > 0 && sh < 128) {
                            print(sh);
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        try { //2.3
                            Integer integer = Integer.parseInt(s);
                            if (integer <= 0 || integer >= 128) {
                                print(integer);
                            } else {
                                throw new Exception();
                            }
                        } catch (Exception r) {
                            print(s);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
