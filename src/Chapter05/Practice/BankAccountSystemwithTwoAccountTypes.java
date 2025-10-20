package Chapter05.Practice;

class SavingAccount extends Chapter05.Practice.BankAccount{
    private final double miniumBalance;
    private double interest;
    private final double annualStandardInterestRate;
    private double bonusRate;

    public SavingAccount(String accountNumber, String holderName, double depositAmount, double annualSpecialInterestRate, double annualStandardInterestRate, int[] time, double miniumBalance, double bonusRate) {
        super(accountNumber, holderName, depositAmount, annualSpecialInterestRate, annualStandardInterestRate, time);
        this.miniumBalance = miniumBalance;
        this.depositAmount = depositAmount;
        this.bonusRate = bonusRate;
        this.annualStandardInterestRate = annualStandardInterestRate;
    }

    @Override
    void calculateInterest(){
        if (depositAmount>=miniumBalance) {
            interest = depositAmount * annualStandardInterestRate + depositAmount * bonusRate;
        }else{
            interest = depositAmount * annualStandardInterestRate;
        }
    }

    public void display(){
        System.out.println("Account Type: Saving Account");
        calculateInterest();
        System.out.println("Interest Calculated:"+interest);
        System.out.println("Account Details: Saving Account | Balance: "+depositAmount+" | Min Balance:"+miniumBalance);
    }
}

class CurrentAccount extends Chapter05.Practice.BankAccount{
    private final double overdraftLimit;
    private final double reducedRate;
    private double interest;
    private final double annualStandardInterestRate;

    public CurrentAccount(String accountNumber, String holderName, double depositAmount, double annualSpecialInterestRate, double annualStandardInterestRate, int[] time, double overdraftLimit, double reducedRate) {
        super(accountNumber, holderName, depositAmount, annualSpecialInterestRate, annualStandardInterestRate, time);
        this.overdraftLimit = overdraftLimit;
        this.reducedRate = reducedRate;
        this.interest = interest;
        this.annualStandardInterestRate = annualStandardInterestRate;
    }

    @Override
    void calculateInterest(){
        interest = depositAmount*annualStandardInterestRate*reducedRate;
    }

    public void display(){
        System.out.println("Account Type:  Current Account");
        calculateInterest();
        System.out.println("Interest Calculated:"+interest);
        System.out.println("Account Details: Current Account | Balance: "+depositAmount+" | Overdraft:"+overdraftLimit);
    }
}

public class BankAccountSystemwithTwoAccountTypes {
    public static void main(String[] args) {
        SavingAccount s1 = new SavingAccount("100","Sam",3000,0.3,0.3,new int[] {1,3},1000,0.3);
        s1.display();
        CurrentAccount c1 = new CurrentAccount("100","Sam",3000,0.3,0.3,new int[] {1,3}, 3000, 0.3);
        c1.display();
    }
}
