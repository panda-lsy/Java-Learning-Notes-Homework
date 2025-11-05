package Chapter06.Practice;

import java.util.Scanner;

public class BasicDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Num:");
                int number = Integer.parseInt(sc.nextLine());
                System.out.println("Divisor:");
                int divisor = Integer.parseInt(sc.nextLine());
                // This line will crash when divisor = 0
                // 当除数为0时，这行代码会崩溃
                int result = number / divisor;
                System.out.println(result);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format");
                System.out.println("Num:");
                int number = Integer.parseInt(sc.nextLine());
                System.out.println("Divisor:");
                int divisor = Integer.parseInt(sc.nextLine());
            }catch (ArithmeticException e) {
                System.out.println("Divisor can't be zero!");
                System.out.println("Divisor:");
                int divisor = Integer.parseInt(sc.nextLine());
            }finally {
                System.out.println("Division by zero is not possible");
            }
        }
    }
}
