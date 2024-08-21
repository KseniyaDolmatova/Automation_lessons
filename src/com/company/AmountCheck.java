// Задание №1
package com.company;

public class AmountCheck {
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return(sum >= 10 && sum <= 20) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isSumInRange (5,5));
    }
}