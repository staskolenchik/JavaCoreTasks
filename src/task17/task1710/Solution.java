package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0].charAt(1)) {
            case 'c' : //create person
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date birthDay = sdf.parse(args[3]);
                    if ("м".equals(args[2]))
                        allPeople.add(Person.createMale(args[1], birthDay));
                    else if ("ж".equals(args[2]))
                        allPeople.add(Person.createFemale(args[1], birthDay));
                    System.out.println(allPeople.size() - 1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

            case 'u' : //update person
                if (Integer.parseInt(args[1]) < allPeople.size()) {
                    try {
                        Person setNewPerson = allPeople.get(Integer.parseInt(args[1]));

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date birthDay = sdf.parse(args[4]);
                        setNewPerson.setName(args[2]);
                        if ("м".equals(args[3]))
                            setNewPerson.setSex(Sex.MALE);
                        else if ("ж".equals(args[3]))
                            setNewPerson.setSex(Sex.FEMALE);
                        setNewPerson.setBirthDate(birthDay);
                        allPeople.set(Integer.parseInt(args[1]), setNewPerson);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case 'd' : //delete person
                if (Integer.parseInt(args[1]) < allPeople.size()) {
                    Person setNullPerson = allPeople.get(Integer.parseInt(args[1]));
                    setNullPerson.setBirthDate(null);
                    setNullPerson.setName(null);
                    setNullPerson.setSex(null);
                    allPeople.set(Integer.parseInt(args[1]), setNullPerson);
                }
                break;

            case 'i' : //show info about person
                if (Integer.parseInt(args[1]) < allPeople.size()) {
                    Person showPerson = allPeople.get(Integer.parseInt(args[1]));
                    StringBuilder showLine = new StringBuilder(showPerson.getName() + " ");
                    if (showPerson.getSex() == Sex.MALE)
                        showLine.append("м").append(" ");
                    else if (showPerson.getSex() == Sex.FEMALE)
                        showLine.append("ж").append(" ");
                    String dateStr = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH)
                            .format(showPerson.getBirthDate());
                    showLine.append(dateStr);
                    System.out.println(showLine.toString());
                }
                break;
        }
    }
}
