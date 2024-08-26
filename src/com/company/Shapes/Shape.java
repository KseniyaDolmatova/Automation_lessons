package com.company.Shapes;

public interface Shape {
    String getFillColor(); // Цвет заливки
    String getBorderColor(); // Цвет границы

    // Расчет периметра
    default double calculatePerimeter() {
        return 0;
    }

    // Расчет площади
    double calculateArea();
}
