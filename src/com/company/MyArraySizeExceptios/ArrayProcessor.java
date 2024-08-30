package com.company.MyArraySizeExceptios;

public class ArrayProcessor {
    public static void validateArray(String[][] array) throws MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Не корректный массив, размер массива должен быть 4x4");
        }
    }

    public static int sumArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Указание на ячейку с 1 (добавлено +1 к индексу)
                    throw new MyArrayDataException("Не удалось посчитать сумму элементов. Ошибка в ячейке на пересечении строки [" + (i + 1) + "] и столбца [" + (j + 1) + "]: " + array[i][j]);
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

        String[][] invalidArray = {
                {"1", "2", "X", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            validateArray(validArray); // Этот вызов пройдет
            System.out.println("Корректный масссив, соответствует размеру 4x4");
            int sum = sumArray(validArray);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            validateArray(invalidArray); // Этот вызов пройдет
            System.out.println("Корректный масссив, соответствует размеру 4x4");
            int sum = sumArray(invalidArray); // Этот вызов вызовет исключение
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}