package Chapter02.Assignment;

import java.util.Scanner;

public class CalculateDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initial Velocity:");
        int vi = sc.nextInt();
        System.out.println("Acceleration:");
        int a = sc.nextInt();
        System.out.println("Time:");
        int t = sc.nextInt();
        int d = vi*t+(a*t*t)/2;
        System.out.println("Distance:"+d+" m");
    }
}
