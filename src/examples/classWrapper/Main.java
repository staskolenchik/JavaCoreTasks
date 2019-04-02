package com.javarush.task.Examples.classWrapper;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Васька");
        Cat catWrap = new CatWrapper(cat);
        printName(cat);
        printName(catWrap);
    }

    public static void printName(Cat name) {
        System.out.println(name.getName());
    }
}
