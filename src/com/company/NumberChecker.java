// Задание №2
package com.company;

public class NumberChecker {
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицательное число");
        }
    }

    public static void main(String[] args) {
        checkNumber(-1);
    }
}

