package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
            out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

                this.address = (String) in.readObject();
                this.year = in.readInt();
                in.close();

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\ABC2\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2011\\resources\\file1.txt");
        FileOutputStream fileOut = new FileOutputStream(file);
        FileInputStream fileInput = new FileInputStream(file);
        ObjectOutput oos = new ObjectOutputStream(fileOut);
        ObjectInput ois = new ObjectInputStream(fileInput);

        Apartment ap = new Apartment("abc", 123);
        ap.writeExternal(oos);

        System.out.println(ap);
        Apartment ap2 = new Apartment();
        ap2.readExternal(ois);

        System.out.println(ap2);

    }
}
