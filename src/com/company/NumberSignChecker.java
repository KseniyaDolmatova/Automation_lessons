// Задание №3
package com.company;

public class NumberSignChecker {
    public static boolean isNegative(int number) {
        return (number < 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isNegative(5));
    }
}

