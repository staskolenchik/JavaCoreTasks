package com.javarush.task.task16.task1615;

/* 
Аэропорт
*/

public class Solution {
    public static volatile Runway RUNWAY = new Runway();   //1 взлетная полоса

    public static void main(String[] args) throws InterruptedException {
        Plane plane1 = new Plane("Самолет #1"); //1.1
        Plane plane2 = new Plane("Самолет #2");
        Plane plane3 = new Plane("Самолет #3");
    }

    private static void waiting() {
        //add your code here - добавь код тут
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void takingOff() { //1.7
        //fix this method - исправь этот метод
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public static class Plane extends Thread {
        public Plane(String name) { //1.2
            super(name); //1.2
            start(); //1.3
        }

        public void run() { //1.4
            boolean isAlreadyTakenOff = false; //1.5 //1.9 =true
            while (!isAlreadyTakenOff) { //1.6 =true
                if (RUNWAY.trySetTakingOffPlane(this)) { //1.6.1    //если взлетная полоса свободна, занимаем ее
                    System.out.println(getName() + " взлетает"); //planeName takeoff
                    takingOff();//взлетает //1.7
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true; //1.8
                    RUNWAY.setTakingOffPlane(null); //1.10 //the way is getting free for next plane
                } else if (!this.equals(RUNWAY.getTakingOffPlane())) {  //если взлетная полоса занята самолетом
                    System.out.println(getName() + " ожидает");
                    waiting(); //ожидает
                }
            }
        }
    }

    public static class Runway { //взлетная полоса
        private Thread t;

        public Thread getTakingOffPlane() {
            return t;
        }

        public void setTakingOffPlane(Thread t) {
            synchronized (this) { //1.10.1
                this.t = t;//1.10.2 this.t = null
            }
        }

        public boolean trySetTakingOffPlane(Thread t) { //1.6.1
            synchronized (this) { //1.6.2 //
                if (this.t == null) { //if thread = null //plane way is free
                    this.t = t; //  thread = t (plane can take the way)
                    return true; //trySetTakingOffPlane(Thread t)  returns true (the way is taken)
                }
                return false; //
            }
        }
    }
}

