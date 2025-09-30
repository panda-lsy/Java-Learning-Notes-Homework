package Chapter02.Practice;

import java.util.Scanner;

public class TheSportsTournamentTieBreaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scoreA = sc.nextInt();
        int scoreB = sc.nextInt();
        System.out.println((scoreA>scoreB)?"Team A won":(scoreA<scoreB)?"Team B won":"It's a tie");
    }
}
