package Chapter02.Assignment;

import java.util.Scanner;

public class CalculateVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Radius:");
        double r = sc.nextDouble();
        System.out.println("Height");
        double h = sc.nextDouble();
        double pi = 22.0/7;
        double volume = pi*r*r*h;
        System.out.println("Volume:"+volume);

    }
}
