package com.Employee;

// Abstract class Shape
abstract class Shape {

    // Abstract method for drawing the shape
    public abstract void draw();

    public  void demo(){
        System.out.println("Demo Method");
    }

    // Abstract method for calculating the area of the shape
    public abstract double area();
}

// Concrete class for Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public double area() {

        return Math.PI * radius * radius;
    }
}

// Concrete class for Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Main class demonstrating abstraction
public class Main {
    public static void main(String[] args) {
        // Create a Circle and a Rectangle
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

//        circle.draw();
//        circle.area();
//        rectangle.draw();
//        rectangle.area();

        // Using abstraction to draw shapes and calculate their area
        drawShape(circle);
        drawShape(rectangle);
    }

    // Function to handle drawing and area calculation using abstraction
    public static void drawShape(Shape shape) {
        shape.draw();
        System.out.println("Area: " + shape.area());
    }
}
