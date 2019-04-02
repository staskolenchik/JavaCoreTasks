package com.javarush.task.task18.task1814;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {


    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[] strArray = fileName.split("\\.");
        if (!"txt".equals(strArray[strArray.length - 1])) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }



    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        TxtInputStream txt = new TxtInputStream("D:\\temp\\text10.txt.exe");
        while (txt.available() > 0) {
            System.out.print(txt.read() + " ");
        }
    }
}

