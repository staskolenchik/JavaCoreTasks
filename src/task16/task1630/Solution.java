package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут

    static
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private static String fileName;
        private static File fileInput;
        private static Scanner fileReader;
        private static StringBuffer stringBuffer = new StringBuffer("");
        /*private static volatile boolean isThreadRun = false;*/

        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            if ("".equals(stringBuffer.toString()))
                return stringBuffer.toString();
            return stringBuffer.toString();
        }

        @Override
        public void run() {
            setFileName(fileName);
            stringBuffer.delete(0, stringBuffer.length());
            try {
                fileInput = new File(fileName);
                fileReader = new Scanner(fileInput); //readfile into object fileReader
                while (fileReader.hasNextLine()) {
                    stringBuffer.append(fileReader.nextLine());
                    stringBuffer.append(" ");
                }
            } catch (FileNotFoundException e) {
                System.err.println("no such file found " + e);
            }
            fileReader.close();
        }
    }
}
