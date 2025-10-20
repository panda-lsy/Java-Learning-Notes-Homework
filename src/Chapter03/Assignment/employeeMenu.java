package Chapter03.Assignment;

import java.util.Scanner;

public class employeeMenu {
    public static int exitState = 0;

    public static void displayMenu() {
        System.out.println("1. Enter Data");
        System.out.println("2. Display Data");
        System.out.println("3. Exit");
    }

    public static void enterData() {
        System.out.println("Entering data...");
    }

    public static void displayData() {
        System.out.println("Displaying data...");
    }

    public static void exitMenu() {
        exitState = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            displayMenu();
            System.out.println("Please enter your choice:");
            int choice = sc.nextInt();
            if (choice == 1) {
                enterData();
            } else if (choice == 2) {
                displayData();
            } else if (choice == 3) {
                exitMenu();
            } else {
                System.out.println("Invalid choice!");
            }
        } while (exitState == 0);
    }
}
