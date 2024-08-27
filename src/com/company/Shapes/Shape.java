package com.company.Shapes;

public abstract class Shape {
    protected String fillColor; // Цвет заливки
    protected String borderColor; // Цвет границы

    public Shape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}
