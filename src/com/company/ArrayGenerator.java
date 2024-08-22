// Задание №10
package com.company;

public class ArrayGenerator {
    public static void main(String[] args) {
        int len = 7;
        int initialValue = 1;

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }

        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

