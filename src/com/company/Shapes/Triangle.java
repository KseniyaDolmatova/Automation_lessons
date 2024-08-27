package com.company.Shapes;

public class Triangle extends Shape implements AreaCalculable, PerimeterCalculable {
    private double sideA; // Сторона A
    private double sideB; // Сторона B
    private double sideC; // Сторона C

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC; // Периметр треугольника
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2; // Полупериметр
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // Площадь треугольника по формуле Герона
    }
}