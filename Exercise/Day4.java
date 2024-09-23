package Exercise;
import java.util.Scanner;

import Exercise.Operations;
import Exercise.Rectangle;

public class Day4 {
    private int num1;
    private int num2;

    public Day4(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    //addition, subtraction, multiplication, division

    public static void main(String[] args) {
        int exNumber = 1;
        int exNumber2 = 2;
        
        Operations operations = new Operations();
        
        Scanner scanner = new Scanner(System.in);

        Day4 number = new Day4(exNumber, exNumber2);
        
        /* System.out.println("Addition: " + operations.add(number.num1, number.num2));
        System.out.println("Subtraction: " + operations.subtract(number.num2, number.num1));
        System.out.println("Multiplication: " + operations.multiply(number.num1, number.num2));
        System.out.println("Division: " + operations.divide(number.num1, number.num2)); */

        System.out.println("Enter the lenght of side a: ");
        double length = scanner.nextDouble();

        System.out.println("Enter the width of side b: ");
        double width = scanner.nextDouble();

        Rectangle rectangle = new Rectangle(length, width);
        System.out.println("The area of the rectangle is: " + rectangle.area());

        scanner.close();
    }
    

}
