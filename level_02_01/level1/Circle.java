package level1;
import java.util.*;
public class Circle {
    double radius;
    Circle() {
        this(1.0);
    }
    Circle(double radius) {
        this.radius = radius;
    }
    void display() {
        System.out.println("Radius: " + radius);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double radius1 = sc.nextDouble();
        Circle c1 = new Circle();
        Circle c2 = new Circle(radius1);
        c1.display();
        c2.display();
    }
}
