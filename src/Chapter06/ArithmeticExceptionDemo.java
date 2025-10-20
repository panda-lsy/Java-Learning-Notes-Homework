package Chapter06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        // Variable to store the first number from user
        // 存储用户输入的第一个数字的变量
        int num1;
        // Variable to store the second number from user
        // 存储用户输入的第二个数字的变量
        int num2;
        // Variable to store the result of division
        // 存储除法结果的变量
        int result;

        // Step 1: Try block - code that might cause an exception or error
        // 步骤1: Try块 - 可能引起异常或错误的代码

        // Create a Scanner object to read input from keyboard
        // 创建Scanner对象从键盘读取输入
        Scanner input = new Scanner(System.in);

        try {

            // Prompt user to enter the first number
            // 提示用户输入第一个数字
            System.out.println("Enter first number");
            // 输入第一个数字
            // Read the first integer input from user (may throw exception)
            // 读取用户的第一个整数输入（可能抛出异常）
            num1 = input.nextInt();

            // Prompt user to enter the second number
            // 提示用户输入第二个数字
            System.out.println("Enter second number");
            // 输入第二个数字
            // Read the second integer input from user (may throw exception)
            // 读取用户的第二个整数输入（可能抛出异常）
            num2 = input.nextInt();

            // Calculate the division of both numbers
            // 计算两个数字的除法
            // it will raise an exception if user entered value for num2 is 0
            // 如果用户为num2输入的值是0，将引发异常
            result = num1 / num2;

            // Display the result to the user
            // 向用户显示结果
            System.out.println("The result is: " + result);
            // 结果是:
        }catch (InputMismatchException e){
            System.out.println("请输入整数");
            // Step 2: Catch block - handles ArithmeticException if it occurs
            // 步骤2: Catch块 - 如果发生ArithmeticException则处理

            // Error message shown when user tries to divide by zero
            // 当用户尝试除以零时显示的错误消息
        }catch (ArithmeticException e){
            System.out.println("0不能作为除数");
            // 除以0是不可能的
        }
    }
}
