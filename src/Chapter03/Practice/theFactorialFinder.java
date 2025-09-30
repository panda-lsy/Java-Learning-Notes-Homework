package Chapter03.Practice;

import java.util.Scanner;

public class theFactorialFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N:");
        int n = sc.nextInt();
        if (n<0){
            System.out.println("Error! Factorial doesn't exist for negative numbers");
        } else if (n==0) {
            System.out.println("The factorial of 0 is 1.");
        }else{
            int factorial=1;
            int n0=n;
            while(n>0){
                factorial = factorial * n;
                n--;
            }
            System.out.println("The factorial of "+n0+" is "+factorial);
        }
    }
}
