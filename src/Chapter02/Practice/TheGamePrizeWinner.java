package Chapter02.Practice;

import java.util.Scanner;

public class TheGamePrizeWinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println((num%3==0 && num%5==0)?"You win a prize!":"Try again.");
    }
}
