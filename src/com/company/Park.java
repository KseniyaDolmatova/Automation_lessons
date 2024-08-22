// Задание №3
package com.company;

import java.util.ArrayList;
import java.util.List;
public class Park {
    private String parkName;
    private String address;
    private List<Attraction> attractions; 
    public Park(String parkName, String address) {
        this.parkName = parkName;
        this.address = address;
        this.attractions = new ArrayList<>();
    }

    private class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        // Конструктор
        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Аттракцион: " + name + ", Время работы: " + workingHours + ", Стоимость: " + cost + " рублей";
        }
    }

    public void addAttraction(String name, String workingHours, double cost) {
        attractions.add(new Attraction(name, workingHours, cost));
    }

    public void displayAttractions() {
        System.out.println("Аттракционы в парке " + parkName + ":");
        for (Attraction attraction : attractions) {
            System.out.println(attraction);
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Сказочный парк", "ул. Счастливая, 10");
        park.addAttraction("Американские горки", "10:00 - 18:00", 300);
        park.addAttraction("Колесо обозрения", "09:00 - 21:00", 200);
        park.displayAttractions();
    }
}

