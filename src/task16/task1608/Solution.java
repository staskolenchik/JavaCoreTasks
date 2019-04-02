package com.javarush.task.task16.task1608;

/* 
Продвижение на политических дебатах
*/

public class Solution {
    public static int totalSpeechCount = 200; //1
    public static int utterancesPerSpeech = 1000000;//2

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");//3   // runs thread 1
        ivanov.join();
        Politician petrov = new Politician("Петров");//runs thread2
        Politician sidorov = new Politician("Сидоров");//runs thread3

        while (ivanov.getSpeechCount() + petrov.getSpeechCount() + sidorov.getSpeechCount() < totalSpeechCount) {
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
        private volatile int utteranceCount; //4.1 =0

        public Politician(String name) {//4.2
            super(name);//5
            start();//6
        }

        public void run() {//7
            while (utteranceCount < totalSpeechCount * utterancesPerSpeech /*0 < (200 * 1000000)*/) { //8
                utteranceCount++; //9
            }
        }

        public int getSpeechCount() {
            return utteranceCount / utterancesPerSpeech;
        }

        @Override
        public String toString() {
            return String.format("%s сказал речь %d раз", getName(), getSpeechCount());
        }
    }
}

