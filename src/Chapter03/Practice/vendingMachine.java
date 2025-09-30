package Chapter03.Practice;

import java.util.Scanner;

public class vendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        System.out.println("1. Coke");
        System.out.println("2. Chips");
        System.out.println("3. Chocolate");
        int choice = sc.nextInt();
        switch (choice){
            case (1):{
                System.out.println("Dispensing Coke - $1.25");
                break;
            }
            case (2):{
                System.out.println("Dispensing Chips - $2.75");
                break;
            }
            case (3):{
                System.out.println("Dispensing Chocolate - $2.75");
                break;
            }
            default: System.out.println("Invalid choice!");
        }

    }
}
