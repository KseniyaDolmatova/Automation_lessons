package com.company.Shapes;

public class Circle extends Shape implements AreaCalculable, PerimeterCalculable {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // Периметр круга
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2); // Площадь круга
    }
}