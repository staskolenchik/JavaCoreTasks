package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;

    static
    {
        Cat cat2 = new Cat();
        cat2.name = "Vaska";
        cat = cat2;
        System.out.println(cat.name);
    }

    public static class Cat {
        public String name;

    }

    public static void main(String[] args) {

    }


}
