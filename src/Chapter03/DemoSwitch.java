package Chapter03;

import java.util.Scanner;

public class DemoSwitch {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        double result;
        Scanner input = new Scanner(System.in);
        System.out.println("Simple Calculator");
        System.out.print("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n");
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        //use switch perform various operations based on user inputs(Menu)
        switch (choice) {
            case 1: {
                result = num1 + num2;
                System.out.println("Addition of " + num1 + " and " + num2 + " is: " + result);
                break;
            }
            case 2: {
                result = num1 - num2;
                System.out.println("Subtraction of " + num1 + " and " + num2 + " is: " + result);
                break;
            }
            case 3: {
                result = num1 * num2;
                System.out.println("Multiplication of " + num1 + " and " + num2 + " is: " + result);
                break;
            }
            case 4: {
                result = (double) num1 / num2;
                System.out.println("Division of " + num1 + " and " + num2 + " is: " + result);
                break;
            }
            default:
                System.out.println("Invalid choice! Please select a valid operation.");
                break;
        }
    }
}
