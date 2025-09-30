package Chapter03.Assignment;

import java.util.Scanner;

public class checkDivisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first number:");
        int first = sc.nextInt();
        System.out.println("Input second number:");
        int second = sc.nextInt();
        if (second==0){
            System.out.println(first+" cannot be divisible by zero");
        }else{
            System.out.println(first+"/"+second+"="+first/second);
        }
    }
}
