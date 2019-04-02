package com.javarush.task.task16.task1610;

/* 
Расставь вызовы методов join()
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка"); //1
        Cat cat2 = new Cat("Пушинка");
    }

    private static void investigateWorld() {
        try {
            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Cat extends Thread {
        protected Kitten kitten1; //2  //=null
        protected Kitten kitten2; //3  //=null

        public Cat(String name) { //4
            super(name); //5
            kitten1 = new Kitten("Котенок 1, мама - " + getName()); //6.1
            kitten2 = new Kitten("Котенок 2, мама - " + getName()); //7.1
            start(); //8
        }

        public void run() { //9
            System.out.println(getName() + " родила 2 котенка"); //10
            try {
                initAllKittens(); //11
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start(); //12
            kitten1.join();
            kitten2.start(); //
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) { //6.2 //7.2
            super(name); //6.3 //7.3
        }

        public void run() { //13
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }
}
