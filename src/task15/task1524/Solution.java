package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных
*/

public class Solution {

    static { //static block (1) runs at first time and no more
        init();
    }

    static { //static block (2) runs at first time and no more
        System.out.println("Static block");
    }

    { // (6) non-static block runs
        System.out.println("Non-static block");// 7
        printAllFields(this); //8
    }

    public int i = 6; //13

    public String name = "First name"; //14


    public Solution() { //15
        System.out.println("Solution constructor"); //16
        printAllFields(this); //17
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void main(String[] args) { //3 main method runs
        System.out.println("public static void main"); //4
        Solution s = new Solution(); //5
    }

    public static void printAllFields(Solution obj) { //9
        System.out.println("static void printAllFields"); //10
        System.out.println(obj.i); //12
        System.out.println(obj.name); //11
    }
}
