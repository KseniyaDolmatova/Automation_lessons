package com.company.Shapes;

public class Rectangle extends Shape implements AreaCalculable, PerimeterCalculable {
    private double width;
    private double height;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height); // Периметр прямоугольника
    }

    @Override
    public double calculateArea() {
        return width * height; // Площадь прямоугольника
    }
}
