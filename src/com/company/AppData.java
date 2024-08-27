package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    // Сохранение данных в CSV файл
    public void save(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < header.length; i++) {
                writer.write(header[i]);
                if (i < header.length - 1) {
                    writer.write(";");
                }
            }
            writer.newLine();

            for (int[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(String.valueOf(row[i]));
                    if (i < row.length - 1) {
                        writer.write(";");
                    }
                }
                writer.newLine();
            }
        }
    }

    // Загрузка данных из CSV файла
    public static AppData load(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");

            String line;
            List<int[]> dataList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] intValues = new int[values.length];
                // Преобразуем строки в целые числа
                for (int i = 0; i < values.length; i++) {
                    intValues[i] = Integer.parseInt(values[i]);
                }
                dataList.add(intValues);
            }

            int[][] data = new int[dataList.size()][];
            dataList.toArray(data);

            return new AppData(header, data);
        }
    }

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
            for (String h : loadedData.header) {
                System.out.print(h + " ");
            }
            System.out.println();

            // Вывод данных
            for (int[] row : loadedData.data) {
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