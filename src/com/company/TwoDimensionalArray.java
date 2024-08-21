// Задание №9
package com.company;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            arr[i][i] = 1;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
