package com.javarush.task.task15.task1505;

import java.util.ArrayList;
import java.util.List;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public static interface LivingPart {
        Object containsBones();
    }

    public static class BodyPart implements LivingPart {
        private String name; //(1.8) большой /*(3.5) рука*/

        public BodyPart(String name) { //(1.6) большой /*(3.3) рука*/
            this.name = name; //(1.7) большой /*(3.4) рука*/
        }

        public Object containsBones() { /*(1.13)*/  /*(3.5)*/
            return "Yes"; /*(1.14) true*/  /*(3.4) рука*/
        }

        public String toString() {
            return ("Yes".equals(containsBones())) ? name + " содержит кости" : name + " не содержит кости";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isArtificial; //(1.10) true

        public Finger(String name, boolean isArtificial) { //(1.4)
            super(name); //(1.5) большой
            this.isArtificial = isArtificial; //(1.9) true
        }

        public Object containsBones() { //(1.11) false
            return "Yes".equals(super.containsBones()) && !isArtificial ? "Yes" : "No"; /*(1.12)*/  /*(1.14) false*/
        }
    }

    public static void main(String[] args) {
        printlnFingers(); //(1)
        printlnBodyParts();
        printlnLivingParts(); /*(3)*/
    }

    private static void printlnLivingParts() { /*(3.1)*/
        System.out.println(new BodyPart("Рука").containsBones()); /*(3.2)*/
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() { //(1.1)
        List<Finger> fingers = new ArrayList<Finger>(5);//(1.2)
        fingers.add(new Finger("Большой", true));//(1.3)
        fingers.add(new Finger("Указательный", true));
        fingers.add(new Finger("Средний", true));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", true));
        System.out.println(fingers.toString());
    }
}

