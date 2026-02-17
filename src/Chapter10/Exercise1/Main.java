package Chapter10.Exercise1;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = {new Circle("Red", 2),
                new Rectangle("Blue", 3,4),
                new Triangle("Green", 2, 10)};
        double totalArea = 0.0;

        printAllAreas(shapes);

        System.out.println("Total area of all shapes: " + totalArea);

    }
    public static void printAllAreas(Shape[] shapes) {
        for(Shape shape: shapes) {
            System.out.println(shape + " Area --> " + shape.getArea() );
        }
    }
}
