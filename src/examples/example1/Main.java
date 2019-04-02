package com.javarush.task.Examples.example1;

public class Main{

final public static void main(String[]args) throws InterruptedException{
Thread cat = new Thread(new Cat());
cat.start();
Thread.sleep(5000);
cat.interrupt();
cat.join();
}

static class Cat implements Runnable{
@Override
public void run() {
while(!Thread.currentThread().isInterrupted()){
System.out.println("Сон начинается");
    try {
        sleep2sec();
    } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.currentThread().interrupt();
    }
    System.out.println("Сон закончился\n");
}
System.out.println("Завершение работы потока");
}

private void sleep2sec() throws InterruptedException{
Thread.sleep(2000);
System.out.println("Сон прерван");


}

}

}
