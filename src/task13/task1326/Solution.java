package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner sc = new Scanner(reader.readLine());

            List<Character> list = new ArrayList<>();
            FileInputStream file = new FileInputStream(sc.nextLine());
            while (file.available() > 0) {
                char a = (char) file.read();
                list.add(a);
            }

           

            StringBuffer strBuff = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                strBuff.append(list.get(i));
            }

            

            String str = strBuff.toString();
            String[] lines =str.split(System.lineSeparator());

            List<Integer> listInt = new ArrayList<>();
            for (String elem :
                    lines) {
                listInt.add(Integer.parseInt(elem));
            }

            Collections.sort(listInt);

            

            for (int i = 0; i < listInt.size(); i++) {
                if (listInt.get(i) % 2 == 0) {
                    System.out.println(listInt.get(i));
                }
            }

            file.close();

        } catch (Exception e) {
            System.err.println("error");

        }

    }
}
