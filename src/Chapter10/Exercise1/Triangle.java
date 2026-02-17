package Chapter10.Exercise1;

public class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return (base * height) / 2.0;
    }

    @Override
    public String toString() {
        return "Triangle{ Color: " + super.getColor() + ", (Height: " +
                this.getHeight() + " , Base: " + this.getBase() + "), Area: "
                + this.getArea() + " }";
    }

}
