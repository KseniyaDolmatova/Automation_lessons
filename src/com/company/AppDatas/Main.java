package com.company.AppDatas;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Первоначальные данные
            String[] header1 = {"Column 1", "Column 2", "Column 3"};

            int[][] data1 = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            AppData appData1 = new AppData(header1, data1);
            appData1.save("data.csv"); // Сохранение первых данных

            // Новые данные
            String[] header2 = {"Column A", "Column B", "Column C"};

            int[][] data2 = {
                    {10, 20, 30},
                    {40, 50, 60}
            };

            AppData appData2 = new AppData(header2, data2);
            appData2.save("data.csv"); // Сохранение новых данных, перезаписывая старые

            // Загрузка данных из файла
            AppData loadedData = AppData.load("data.csv");

            // Вывод заголовков
            System.out.print("Заголовки: ");
            for (String h : loadedData.getHeader()) {
                System.out.print(h + " ");
            }
            System.out.println();

            // Вывод данных
            for (int[] row : loadedData.getData()) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата числа: " + e.getMessage());
        }
    }
}