package com.javarush.task.task19.task1904;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] strArray;
            if (fileScanner.hasNextLine()) {
                strArray = fileScanner.nextLine().split(" ");
                SimpleDateFormat s = new SimpleDateFormat("dd MM yyyy");
                StringBuilder strB = new StringBuilder(strArray[5]);
                while (strB.length() > 4) {
                    strB.deleteCharAt(4);
                }
                strArray[5] = strB.toString();
                Date date = null;
                try {
                    date = s.parse(strArray[3] + " " + strArray[4] + " " + strArray[5]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return new Person(strArray[0], strArray[1], strArray[2], date);
            } else {
                return null;
            }
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
