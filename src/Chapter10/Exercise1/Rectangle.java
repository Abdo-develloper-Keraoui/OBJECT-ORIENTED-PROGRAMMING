package Chapter10.Exercise1;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(String color, double height, double width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{ Color: " + super.getColor() + ", (Height: " +
                this.getHeight() + " , Width: " + this.getWidth() + "), Area: "
                + this.getArea() + " }";
    }
}
