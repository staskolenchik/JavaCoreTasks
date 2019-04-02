package com.javarush.task.Examples.example3;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        //wrap string into class ByteArrayInputStrream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        //change in
        System.setIn(is);

        //invoke trivial method, which dont know about our manipulations
        readAndPrintLine();
    }

    public static void readAndPrintLine() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while(true) {
            String line = reader.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }

}
