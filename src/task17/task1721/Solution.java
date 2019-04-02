package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            //1 create stream to read bytes of text
            //while file has any bytes of text read it ===> add to StringBuffer strBuffer
            //if char new line == nextByte ===> add to allLines
            FileInputStream file1 = new FileInputStream(sc.nextLine());
            FileInputStream file2 = new FileInputStream(sc.nextLine());

            BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(file1));
            BufferedReader fileReader2 = new BufferedReader(new InputStreamReader(file2));

            String str;

            while ((str = fileReader1.readLine()) != null) { //read line from file1
                allLines.add(str);
            }

            while ((str = fileReader2.readLine()) != null) {
                forRemoveLines.add(str);
            }

            file1.close();
            file2.close();
            fileReader1.close();
            fileReader2.close();

        } catch (Exception e) {

        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Data of 2 files is different!");
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }



    }
}
