package Chapter10.Exercise1;

public class Circle extends Shape {

    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{ Color: " + super.getColor() + ", Radius: " +
                this.getRadius() + " , Area: " + this.getArea() + " }";
    }
}
