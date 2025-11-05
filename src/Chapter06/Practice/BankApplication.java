package Chapter06.Practice;

import java.util.Scanner;

class InsuffcientFundsException extends RuntimeException{
    public InsuffcientFundsException(double amount, double balance){
        super("withdrawal amount "+amount+" is greater than the available balance "+balance);
        System.out.println("withdrawal amount "+amount+" is greater than the available balance "+balance);
    }
}

public class BankApplication {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input withdrawal amount");
        double amount = sc.nextDouble();
        System.out.println("Input available balance");
        double balance = sc.nextDouble();

        if (amount>balance){
            throw new InsuffcientFundsException(amount,balance);
        }else{
            System.out.println("Success!");
        }
    }
}
