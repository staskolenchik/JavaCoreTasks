package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван"); //(1)creates variable ivan type Person
        for (Money money : ivan.getAllMoney()) { //(7) перебор каждого элемента money типа Money листа allMoney
            System.out.println(ivan.name/*(8) вызов значения name объекта ivan*/ + " имеет заначку в размере "
                    + money.getAmount() /*(9) вызов метода getAmount() объекта money*/
                    + " " + money.getCurrencyName() /*(10) вызов метода getCurrencyName() объекта money*/);
        }
    }

    static class Person {
        public String name; //(4)Иван

        Person(String name) { //(2)Иван
            this.name = name; //(3)Иван
            this.allMoney = new ArrayList<Money>();//(5)инициализирует this.allMoney список типа Money
            //напишите тут ваш код
            //fulfill this.allMoney collection
            allMoney.add(new Hrivna(200.6)); //(5.1)
            allMoney.add(new Ruble(1200.90));//(5.2)
            allMoney.add(new USD(58.02));//(5.3)


        }

        private List<Money> allMoney; //(6) new ArrayList<Money>()

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
