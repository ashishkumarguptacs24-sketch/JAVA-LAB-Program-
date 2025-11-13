// Abstract class Shape
abstract class Shape {
    int dim1, dim2;

    // Constructor
    Shape(int a, int b) {
        dim1 = a;
        dim2 = b;
    }

    // Abstract method to print area
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {

    Rectangle(int a, int b) {
        super(a, b);
    }

    void printArea() {
        double area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class
class Triangle extends Shape {

    Triangle(int a, int b) {
        super(a, b);
    }

    void printArea() {
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class
class Circle extends Shape {

    Circle(int radius) {
        super(radius, 0); // second argument unused
    }

    void printArea() {
        double area = Math.PI * dim1 * dim1;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class
public class ShapeDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        Triangle tri = new Triangle(10, 8);
        Circle cir = new Circle(7);

        rect.printArea();
        tri.printArea();
        cir.printArea();
    }
}

