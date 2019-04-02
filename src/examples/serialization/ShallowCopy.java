package com.javarush.task.examples.serialization;

public class ShallowCopy {
    public static void main(String[] args) {
        Person hus0 = new Person();
        hus0.name = "Mile";
        Person wife = new Person();
        wife.name = "Sara";
        hus0.couple = wife;
        wife.couple = hus0;
        Person hus1 = new Person(hus0);
    }
}

class Person {
    public Person() {
    }

    public Person(Person source) {
        this.name = source.name;
        this.couple = source.couple;
    }

    public String name;
    public Person couple;

}
