package Chapter03.Activity;

class BankAccount{
    String AccountHolderName;
    int balance;

    void withdraw(int amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is " + amount);
        } else {
            System.out.println("Insufficient funds! You cannot withdraw "+amount+".");
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.AccountHolderName = "Zhang Wei";
        myAccount.balance = 1000;
        myAccount.withdraw(500);  // Successful withdrawal
        myAccount.withdraw(800);  // Insufficient funds
    }
}
