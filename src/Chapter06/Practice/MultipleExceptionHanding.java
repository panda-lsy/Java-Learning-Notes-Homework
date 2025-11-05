package Chapter06.Practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleExceptionHanding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int[] nums = readThreeInts(sc);
                int result = (nums[0] + nums[1]) / nums[2];
                System.out.println(result);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter numbers only! Try again.");
                sc.nextLine(); // 清除错误输入
            } catch (NumberFormatException e) {
                System.out.println("Please enter whole numbers only! No decimals or symbols.");
            } catch (ArithmeticException e) {
                System.out.println("You cannot divide by zero! Please enter a different number.");
            }catch (NullPointerException e){
                System.out.println("Please enter a number! Don't leave it blank.");
            }
        }
        sc.close();
    }

    private static int[] readThreeInts(Scanner sc) {
        int n1 = readInt(sc, "Num1:");
        int n2 = readInt(sc, "Num2:");
        int d  = readInt(sc, "Divisor:");
        assert d != 0 : "Divisor must not be zero";
        return new int[]{n1, n2, d};
    }

    private static int readInt(Scanner sc, String prompt) {
        System.out.println(prompt);
        String line = sc.nextLine();
        return Integer.parseInt(line.trim());
    }
}
