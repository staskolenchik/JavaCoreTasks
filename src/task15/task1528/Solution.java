package com.javarush.task.task15.task1528;

/* 
ООП. Hrivna — тоже деньги
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
        System.out.println(new USD().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        public double amount = 123d;

        public Hrivna getMoney() {
            return this;
        }
        @Override
        public Double getAmount() {
            return getMoney().amount;
        }
    }

    public static class USD extends Money {
        public double amount = 50d;

        public USD getMoney() {
            return this;
        }
        @Override
        public Double getAmount() {
            return getMoney().amount;
        }
    }
}
