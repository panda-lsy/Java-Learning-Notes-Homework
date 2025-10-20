package Chapter05.Practice;

class BankAccount{
    private String accountNumber;
    private String holderName;
    double depositAmount;
    private double annualStandredInterestRate;
    private double annualSpecialInterestRate;
    private int [] time;

    public BankAccount(String accountNumber, String holderName, double depositAmount, double annualSpecialInterestRate, double annualStandardInterestRate,int [] time){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.annualSpecialInterestRate = annualSpecialInterestRate;
        this.annualStandredInterestRate = annualStandardInterestRate;
        this.depositAmount = depositAmount;
        this.time = time;
    }

    boolean dataValidation(){
        if (depositAmount<0){
            System.out.println("Error: DepositAmount below 0");
            depositAmount = 0;
            return false;
        }
        if(annualStandredInterestRate<0 || annualStandredInterestRate>1){
            System.out.println("Error: Invalid Rate!");
            annualStandredInterestRate = 0;
            return false;
        }
        if(annualSpecialInterestRate<0 || annualSpecialInterestRate>1){
            System.out.println("Error: Invalid Rate!");
            annualSpecialInterestRate = 0;
            return false;
        }
        for (int time0 : time) {
            if (time0 < 0) {
                System.out.println("Error: Invalid Time!");
                return false;
            }
        }
        return true;
    }

    void calculateInterest(){
        if (dataValidation()) {
            System.out.println("Bank Interest Calculation Results:");
            for (int time0: time) {
                System.out.print("Interest for " + time0 + " year(s):");
                System.out.printf("%.1f\n", depositAmount * annualStandredInterestRate * time0);
                System.out.print("Interest with special rate for " + time0 + " year(s):");
                System.out.printf("%.1f\n", depositAmount * annualSpecialInterestRate * time0);
            }
        }
    }
}
public class BankInterestCalculatorSystem {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("1013","Wang",9000,0.03,0.07, new int[]{1, 3});
        b1.calculateInterest();
    }
}
