package com.self.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Circle {

    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

static class Sortbyname implements Comparator<Circle> {
    // Used for sorting in ascending order of 
    // roll name 
    public int compare(Circle a, Circle b) {
        return Double.compare(a.radius, b.radius);
    }
}

    public static void main(String[] args) {
        List<Circle> al = new ArrayList();
        Circle c1 = new Circle(6);
        Circle c2 = new Circle(5);
        Circle c3 = new Circle(4);
        al.add(c1);
        al.add(c2);
        al.add(c3);
        Collections.sort(al, new Sortbyname());
        System.out.println("\n\nAfter Sorting:\n");
        for (Circle customer : al) {
            System.out.println(customer);
        }
    }
}
