package com.company.MyArraySizeExceptios;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4) {
            throw new MyArraySizeException("Не корректный массив, количество строк должно быть 4");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Не корректный массив, количество столбцов должно быть 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке на пересечении строки [" + (i + 1) + "] и столбца [" + (j + 1) + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "0", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidArraySize = {
                {"1", "2", "3", "4"},
                {"5", "0", "7"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidArrayData = {
                {"1", "2", "X", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Проверяем корректный массив
        try {
            int sum = processArray(validArray);
            System.out.println("Корректный массив: сумма элементов = " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // Проверяем массив с некорректным размером
        try {
            int sum = processArray(invalidArraySize);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        // Проверяем массив с некорректными данными
        try {
            int sum = processArray(invalidArrayData);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}