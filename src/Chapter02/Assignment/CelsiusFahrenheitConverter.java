package Chapter02.Assignment;

import java.util.Scanner;

public class CelsiusFahrenheitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Celsius:");
        double celsius = sc.nextDouble();
        double fahrenheit = celsius*9/5+32.0;
        System.out.println("Fahrenheit:"+fahrenheit);
    }
}
