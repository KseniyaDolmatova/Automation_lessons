package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Возраст: " + age + ")";
    }
}


public class StudentAnalysis {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Алексей", 20, "Мужской"),
                new Student("Евгений", 30, "Мужской"),
                new Student("Мария", 22, "Женский"),
                new Student("Дмитрий", 19, "Мужской"),
                new Student("Иван", 25, "Мужской"),
                new Student("Екатерина", 21, "Женский"),
                new Student("Сергей", 27, "Мужской"),
                new Student("Михаил", 17, "Мужской")
        );

        // Средний возраст студентов мужского пола
        double averageAge = students.stream()
                .filter(student -> "Мужской".equalsIgnoreCase(student.getGender()))
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);

        System.out.println("Средний возраст студентов мужского пола: " + averageAge);

        // Студенты, которым грозит получение повестки (18-27 лет)
        List<Student> draftEligibleStudents = students.stream()
                .filter(student -> "Мужской".equalsIgnoreCase(student.getGender()) && (student.getAge() >= 18 && student.getAge() <= 27))
                .collect(Collectors.toList());

        System.out.println("Студенты, которым грозит получение повестки:");
        draftEligibleStudents.forEach(System.out::println);
    }

}