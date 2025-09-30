package Chapter03.Practice;

import java.util.Scanner;

public class BankAccountStatusCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input balance:");
        double balance = sc.nextDouble();
        if(balance>0){
            System.out.println("Account in good standing.");
        } else if (balance<0) {
            System.out.println("Account overdrawn.");
        }else{
            System.out.println("Account balance is zero.");
        }
    }
}
