package com.company;

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class ArrayCheck {

    public static void processArray(String[][] array) throws MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива. Ожидался размер 4х4.");
        }

        System.out.println("Массив корректен, размер 4x4.");
    }

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidArray = {
                {"1", "2"},
                {"3", "4"}
        };

        try {
            processArray(validArray);
            processArray(invalidArray);
        } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        }
    }
}
