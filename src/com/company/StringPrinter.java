// Задание №4
package com.company;

public class StringPrinter {
    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        printString("Задание номер 4", 5);
    }
}

