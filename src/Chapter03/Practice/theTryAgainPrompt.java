package Chapter03.Practice;

import java.util.Scanner;

public class theTryAgainPrompt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input=0;
        do{
            System.out.println("Enter a positive number:");
            input = sc.nextInt();
            if (input<=0){
                System.out.println("Invalid input. Try again.");
            }
        }while (input<=0);
        System.out.println("You entered:"+input);
    }
}
