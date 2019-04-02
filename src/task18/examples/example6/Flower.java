package com.javarush.task.task18.examples.example6;

public class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals) {//(3) the initialization of object starts here (1)
        petalCount = petals;
        System.out.println("Конструктор с параметром int, petalCount = " + petalCount);
    }

    Flower(String str) {
        System.out.println("Констркутор с параметром String, s= " + str);
        s = str;
    }

    Flower(String s, int petals) { //(2) then initialization of this constructor (2)
        this(petals);
        this.s = s;
        System.out.println("Аргументы String и int");
    }

    Flower() { //(1) then initialization of default constructor (1)
        this("hi", 47); //==> goes to this Flower(String s, int petals)
        System.out.println("Конструктор по умолчанию без аргументов");
    }
    void printPetalCount() {
        System.out.println("petalCount = " + petalCount + " s = " + s); //(4)
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
