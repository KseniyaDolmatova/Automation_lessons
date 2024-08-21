// Задание №8
package com.company;

public class MultiplyNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < 12; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        for (int i = 0; i < 12; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
