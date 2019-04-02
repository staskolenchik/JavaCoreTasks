package com.javarush.task.task16.task1607;

import java.util.ArrayList;
import java.util.List;

/* 
Horse Racing
*/

public class Solution {
    public static int horseCount = 10; //(1)

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(); //(2)
        while (calculateHorsesFinished(horses) != horseCount) { //(10) cycle while finished horses not end up the race
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        //add your implementation here - добавь свою реалзацию тут

        for (Horse horse :
                horses) {
            if (horse.isFinished()) {
                finishedCount++;
            } else {
                System.out.println("Waiting for " + horse.getName());
                horse.join();
            }
        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart() { //(3)
        List<Horse> horses = new ArrayList<Horse>(horseCount);//(4) //creates list with 10 elements
        String number;
        for (int i = 1; i < horseCount + 1; i++) {//(5) //gives each horse a name
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number)); //(6)
        }

        for (int i = 0; i < horseCount; i++) { //(7)
            horses.get(i).start(); //(8)//creates 10 threads// watch below
        }
        return horses; //(9) //returns Horse horse which has own name
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() { // starts thread
            String s = "";
            for (int i = 0; i < 1001; i++) {   //delay
                s += "" + i;
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}
