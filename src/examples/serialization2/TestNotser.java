package com.javarush.task.examples.serialization2;

import java.io.IOException;

public class TestNotser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] raw = SerUtils.objToByte(new Ser());
        Object obj = SerUtils.byteToObj(raw);
    }
}
