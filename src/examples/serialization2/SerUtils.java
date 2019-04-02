package com.javarush.task.examples.serialization2;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;

import java.io.*;

public class SerUtils {
    public static byte[] objToByte(Object object) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(buff);
        out.writeObject(object);
        out.flush();
        out.close();
        return buff.toByteArray();
    }

    public static Object byteToObj (byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        return in.readObject();
    }
}
