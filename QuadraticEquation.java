import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter value of a: ");
        double a = input.nextDouble();

        System.out.println("Enter value of b: ");
        double b = input.nextDouble();

        System.out.println("Enter value of c: ");
        double c = input.nextDouble();

        //Double Discriminant 
        double discriminant =  b * b - 4 * a * c;

        if (discriminant > 0 ) {
            double root1 = ( -b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has two real Solution.");
            System.out.println("Root 1: " +root1);
            System.out.println("Root 2: " +root2);
        }
        else if (discriminant == 0) {
            double root = -b / ( 2 * a);
             System.out.println("The equation has one real Solution.");
             System.out.println("Root : " +root);
        }
        else {
             System.out.println("The equation has no real Solution.");
        }
        input.close();
    }

}
