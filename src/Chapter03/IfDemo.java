package Chapter03;

import java.util.Scanner;

public class IfDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your value for Number 1:");
        int num1 = sc.nextInt();
        System.out.println("Enter your value for Number 2:");
        int num2 = sc.nextInt();
        // 通过 if 找到更大的数字
        if (num1 > num2) {
            System.out.println("Number 1 is greater than Number 2");
        } else if (num1 < num2) {
            System.out.println("Number 1 is less than Number 2");
        } else {
            System.out.println("Number 1 is equal to Number 2");
        }
    }
}
