package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            //args[0] = -c; args[1] = productname; args[2] = price; args[3] = quantity;

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = consoleReader.readLine();
            BufferedInputStream fileReader =
                    new BufferedInputStream(new FileInputStream(fileName));
            //
            //create add to the existing file new line of the
            //1 read data from file and identify id
            //add to string array each line of the file
            //the whole file read into a string
            StringBuilder fileAsString = new StringBuilder("");
            while (fileReader.available() > 0) {
                fileAsString.append((char) fileReader.read());
            }
            fileReader.close();

            String[] lines = fileAsString.toString().split("\r\n"); // have an array of lines
            //I know a number of characters, of each column
            //I should get an id of last line
            //1) in each line find id (int type)
            //2) add to ArrayList<Integer>
            //3) sort desc collection
            //4) get the first element
            /**
             * version 2.0
             * */
            List<Integer> idList = new ArrayList<>();
            for (String eachLine :
                    lines) {
                StringBuilder idStr = new StringBuilder("");
                char[] charArrayOfEachLine = eachLine.toCharArray();
                for (int i = 0; i < 8; i++) {
                    if (charArrayOfEachLine[i] != ' ')
                        idStr.append(charArrayOfEachLine[i]);
                }
                idList.add(Integer.parseInt(idStr.toString()));
            }
            Collections.sort(idList);
            Collections.reverse(idList);

            /**
             * version 1.0
             * */

            List<Character> maxIdChars = new ArrayList<>();
            char[] charArray = idList.get(0).toString().toCharArray();
            for (char chars :
                    charArray) {
                maxIdChars.add(chars);
            }

            StringBuilder maxIdBuilder = new StringBuilder("");
            while (maxIdChars.size() < 8) {
                maxIdChars.add(' ');
            }

            for (char chars :
                    maxIdChars) {
                maxIdBuilder.append(chars);
            }

            String maxIdLine = maxIdBuilder.toString();
            char[] maxIdLineIntoCharArray = maxIdLine.toCharArray();
            StringBuilder currentIdString = new StringBuilder("");
            for (int i = 0; i < 8; i++) {
                if (maxIdLineIntoCharArray[i] != ' ')
                    currentIdString.append(maxIdLineIntoCharArray[i]);
            }

            Integer newLineId = Integer.parseInt(currentIdString.toString()) + 1; //got a new id
            char[] newLineIdChars = newLineId.toString().toCharArray();

            //add id chars
            List<Character> newlistId = new ArrayList<>();
            for (char chars :
                    newLineIdChars) {
                newlistId.add(chars);
            }
            while (newlistId.size() < 8) { //conta
                newlistId.add(' ');
            }

            //add product name chars
            String newProductName = args[1];
            char[] newProductNameChars = newProductName.toCharArray();
            List<Character> newListProductName = new ArrayList<>();
            for (char chars :
                    newProductNameChars) {
                newListProductName.add(chars);
            }
            while (newListProductName.size() < 30) {
                newListProductName.add(' ');
            }

            //add price chars
            String newPrice = args[2];
            char[] newPriceChars = newPrice.toCharArray();
            List<Character> newListPrice = new ArrayList<>();
            for (char chars :
                    newPriceChars) {
                newListPrice.add(chars);
            }
            while (newListPrice.size() < 8) {
                newListPrice.add(' ');
            }

            //add price chars
            String newQuantity = args[3];
            char[] newQuantityChars = newQuantity.toCharArray();
            List<Character> newListQuantity = new ArrayList<>();
            for (char chars:
                    newQuantityChars) {
                newListQuantity.add(chars);
            }
            while (newListQuantity.size() < 4) {
                newListQuantity.add(' ');
            }

            StringBuilder newLine = new StringBuilder("");
            //add new id
            for (Character chars:
                    newlistId) {
                newLine.append(chars);
            }
            //add new productname
            for (Character chars:
                    newListProductName) {
                newLine.append(chars);
            }
            //add new price
            for (Character chars:
                    newListPrice) {
                newLine.append(chars);
            }
            //add new quatity
            for (Character chars:
                    newListQuantity) {
                newLine.append(chars);
            }
            newLine.append("\r\n");

            //add id at new line
            //id must contain 8 characters, productname - 30 chars, price - 8 chars with ".", quantity - 4 chars
            //add a "space" if the number of charactes doesn't equal to that number
            for (int i = 0; i < lines.length; i++) {
                String someLine = lines[i] + "\r\n";
                lines[i] = someLine;
            }
            BufferedOutputStream bufferWriter = new BufferedOutputStream(new FileOutputStream(fileName));
            for (int i = 0; i < lines.length; i++) {
                bufferWriter.write(lines[i].getBytes());
            }
            bufferWriter.write(newLine.toString().getBytes());
            bufferWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
