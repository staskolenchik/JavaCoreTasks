package com.javarush.task.task16.task1612;

/* 
Stopwatch (Секундомер)
*/

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4); //(1.1)creates obj with name and speed
        Runner petrov = new Runner("Petrov", 2);
        //на старт!
        //внимание!
        //марш!
        ivanov.start(); //(2.1)
        petrov.start();
        Thread.sleep(2000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Stopwatch extends Thread { //4
        private Runner owner; //(1.4) =this obj //(1.6) =this obj
        private int stepNumber; //(1.4) =0 //(1.6) =0

        public Stopwatch(Runner runner) { //(1.5) this obj
            this.owner = runner; //(1.5) = this obj
        }

        public void run() { //(2.4)
            try {
                while (!isStopped) { //(2.5) =true
                    doStep(); //(2.6)
                }
            } catch (InterruptedException e) {
            }
        }

        private void doStep() throws InterruptedException { //(2.7)
            stepNumber++; //(2.8) //= 0 + 1 = 1
            //add your code here - добавь код тут
            Thread.sleep(1000/owner.getSpeed());
            System.out.println(owner.getName() + " делает шаг №" + stepNumber + "!");



        }
    }

    public static class Runner {
        Stopwatch stopwatch; //(1.2) =null //(1.4) =this obj
        private String name; //(1.2) =null //(1.4) ="Ivanov"
        private int speed; //(1.2) =null //(1.4) =4

        public Runner(String name, int speed) { //(1.3) ("Ivanov", 4)
            this.name = name; //(1.3) "Ivanov"
            this.speed = speed;//(1.3) 4
            this.stopwatch = new Stopwatch(this); //(1.3) this obj
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public void start() { //(2.2)
            stopwatch.start(); //(2.3)
        }
    }
}
