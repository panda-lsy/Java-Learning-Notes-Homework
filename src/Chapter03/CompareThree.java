package Chapter03;

import  java.util.Scanner;

public class CompareThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first value for Number 1:");
        int a = sc.nextInt();
        System.out.println("Enter your second value for Number 2:");
        int b = sc.nextInt();
        System.out.println("Enter your third value for Number 3:");
        int c = sc.nextInt();
        // 通过 if 找到最大的数字
        if (a >= b && a >= c) {
            System.out.println("Number 1 is the greatest");
        } else if (b >= c) {
            System.out.println("Number 2 is the greatest");
        } else {
            System.out.println("Number 3 is the greatest");
        }
    }
}
