package Chapter03.Practice;

import java.util.Scanner;

public class trafficLightSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Current Color:");
        char currentState = sc.next().charAt(0);
        if (currentState=='R'){
            System.out.println("Stop");
        } else if (currentState=='Y') {
            System.out.println("Ready");
        } else if (currentState=='G') {
            System.out.println("Go");
        }else{
            System.out.println("Invalid Char!");
        }
    }
}
