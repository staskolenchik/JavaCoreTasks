package com.javarush.task.task13.task1327;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) { // (2)  receive List "plot"
        Person first; //(3) creates variable type Person
        Person second; //(4) creates variable type Person
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i - 1);// object[3] = бабка
            second = items.get(i);// object[4] = внучка
            second.pull(first);
        }
    }
}
