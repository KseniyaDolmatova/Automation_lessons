package com.company;

public class N2 {
    public static void main(String[] args) {
        checkSumSign();
    }

    public static void checkSumSign() {
        int a = 7; // Вы можете выбрать любые значения
        int b = -10; // Вы можете выбрать любые значения

        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}
