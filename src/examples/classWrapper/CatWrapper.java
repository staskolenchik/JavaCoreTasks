package com.javarush.task.Examples.classWrapper;

public class CatWrapper extends Cat {
    private Cat original;

    public CatWrapper(Cat cat) {
       this.original = cat;
    }

    public String getName() {
        return "Кот по имени " + original.getName();
    }

    public void setName(String name) {
        original.setName(name);
    }
}
