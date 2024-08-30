package com.company.AppDatas;

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

    // Геттер для заголовков
    public String[] getHeader() {
        return header;
    }

    // Геттер для данных
    public int[][] getData() {
        return data;
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

            List<int[]> dataList = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] intValues = java.util.Arrays.stream(values)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                dataList.add(intValues);
            }

            int[][] data = new int[dataList.size()][];
            dataList.toArray(data);

            return new AppData(header, data);
        }
    }
}