package Chapter03;

import java.util.Scanner;

public class NestedIfElse {
    public static void main(String[] args) {
        System.out.println("Enter your mark: ");
        Scanner sc = new Scanner(System.in);
        double mark = sc.nextDouble();
        if (mark >= 0 && mark <= 100) {
            if (mark >= 90) {
                System.out.println("Your grade is A");
            } else if (mark >= 80) {
                System.out.println("Your grade is B");
            } else if (mark >= 70) {
                System.out.println("Your grade is C");
            } else if (mark >= 60) {
                System.out.println("Your grade is D");
            } else {
                System.out.println("Your grade is F");
            }
        } else {
            System.out.println("Invalid mark! Please enter a mark between 0 and 100.");
        }
    }
}
