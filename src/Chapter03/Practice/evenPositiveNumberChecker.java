package Chapter03.Practice;

import java.util.Scanner;

public class evenPositiveNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num%2==0 && num>0){
            System.out.println("Valid Number");
        }
        else{
            System.out.println("Invalid Number");
        }
    }
}
