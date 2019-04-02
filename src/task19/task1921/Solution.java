package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));


            while (fileReader.ready()) {
                StringBuilder line = new StringBuilder("");
                StringBuilder nameStrBldr = new StringBuilder("");
                StringBuilder dateStrBldr = new StringBuilder("");
                List<String> arrayList = new ArrayList<>();
                line.append(fileReader.readLine());
                arrayList = Arrays.asList(line.toString().split(" "));
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        int num = Integer.parseInt(arrayList.get(i));
                        dateStrBldr.append(num).append("/");
                    } catch (NumberFormatException e) {
                        nameStrBldr.append(arrayList.get(i)).append(" ");
                    }
                }

                nameStrBldr.deleteCharAt(nameStrBldr.length() - 1);
                dateStrBldr.deleteCharAt(dateStrBldr.length() - 1);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy", Locale.ENGLISH);
                Date date = sdf.parse(dateStrBldr.toString());
                String name = nameStrBldr.toString();
                PEOPLE.add(new Person(name, date));
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
