package com.company.Shapes;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 6, "Blue", "Green");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());

        if (shape instanceof PerimeterCalculable) {
            System.out.printf("Периметр: %.2f м.%n", ((PerimeterCalculable) shape).calculatePerimeter());
        }

        if (shape instanceof AreaCalculable) {
            System.out.printf("Площадь: %.2f м²%n", ((AreaCalculable) shape).calculateArea());
        }

        System.out.println();
    }
}