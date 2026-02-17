package Chapter10.Exercise1;
/**
 * Exercise 9.1 — Create a class hierarchy: Shape (parent) with color field
 * and getArea() method (returns 0). Then create Circle (with radius) and
 * Rectangle (with width, height) that extend Shape and override getArea().*/

public class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public double getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return "Shape {: " + color + ", Area" + getArea() + " }";
    }
}
