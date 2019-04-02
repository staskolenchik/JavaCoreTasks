package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        System.out.println("I am superman");
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("C:\\ABC2\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\resources\\file1.txt");
        OutputStream fileOut = new FileOutputStream(file);
        InputStream fileInput = new FileInputStream(file);
        Solution s1 = new Solution(10);
        ObjectOutput oos = new ObjectOutputStream(fileOut);
        oos.writeObject(s1);
        oos.close();
        ObjectInput ois = new ObjectInputStream(fileInput);
        Solution s2 = (Solution) ois.readObject();


    }
}
