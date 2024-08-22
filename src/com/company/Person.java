// Задание №2
package com.company;

public class Person {
    String name;
    String position;
    String email;
    String phone;
    double salary;
    int age;

    public Person(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Должность: " + position + ", Email: " + email +
                ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age);
    }

    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Иванов Иван", "Инженер", "ivivan@mailbox.com", "892312312", 28300, 30);
        persArray[1] = new Person("Петров Петр", "Менеджер", "petrov@mailbox.com", "892312313", 41700, 45);
        persArray[2] = new Person("Сидоров Сидор", "Техник", "sidorov@mailbox.com", "892312314", 25000, 50);
        persArray[3] = new Person("Кузнецов Кузя", "Аналитик", "kuznetsov@mailbox.com", "892312315", 350000, 38);
        persArray[4] = new Person("Орлов Олег", "Дизайнер", "orlov@mailbox.com", "892312316", 1000, 20);

        for (Person person : persArray) {
            if (person.getAge() > 40) {
                person.displayInfo();
            }
        }
    }
}