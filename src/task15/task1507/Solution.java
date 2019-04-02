package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    
    public  static void printMatrix(byte m, byte n, String value) { //3
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(short m, short n, String value) { //4
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(long m, long n, String value) { //5
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(float m, float n, String value) { //6
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(double m, double n, String value) { //7
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(double m, double n, Object value) { //8
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(byte m, byte n, Object value) { //9
        System.out.println("Заполняем объектами String");
    }
    
    public  static void printMatrix(short m, short n, Object value) { //10
        System.out.println("Заполняем объектами String");
    }
    
    
}
