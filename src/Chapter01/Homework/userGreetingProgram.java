package Chapter01.Homework;

import java.util.Scanner;

public class userGreetingProgram {
    Scanner sc = new Scanner(System.in);

    public void greetUser() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        userGreetingProgram ugp = new userGreetingProgram();
        ugp.greetUser();
    }
}
