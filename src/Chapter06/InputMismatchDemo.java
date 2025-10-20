// Define the package name for chapter 6
// 定义第6章的包名
package Chapter06;
// Import the exception class for handling input errors
// 导入处理输入错误的异常类
import java.util.InputMismatchException;
// Import Scanner class for reading user input
// 导入用于读取用户输入的Scanner类
import java.util.Scanner;
// Main class that demonstrates exception handling
// 演示异常处理的主类
public class InputMismatchDemo {
    // Main method where program execution begins
// 程序开始执行的主方法
    public static void main(String[] args) {
// Variable to store the first number from user
// 存储用户输入的第一个数字的变量
        int num1;
        // Variable to store the second number from user
        // 存储用户输入的第二个数字的变量
        int num2;
        // Variable to store the sum of both numbers
        // 存储两个数字之和的变量
        int result;

        // Step 1: Try block - code that might cause an exception or error
        // 步骤1: Try块 - 可能引起异常或错误的代码
        // Create a Scanner object to read input from keyboard
        // 创建Scanner对象从键盘读取输入
        Scanner input = new Scanner(System.in);

        // Prompt user to enter the first number
        // 提示用户输入第一个数字
        System.out.println("Enter first number");
        // 输入第一个数字
        // Read the first integer input from user (may throw exception)
        // 读取用户的第一个整数输入（可能抛出异常）
        try{
            num1 = input.nextInt();

            // Prompt user to enter the second number
            // 提示用户输入第二个数字
            System.out.println("Enter second number");
            // 输入第二个数字
            // Read the second integer input from user (may throw exception)
            // 读取用户的第二个整数输入（可能抛出异常）
            num2 = input.nextInt();


            // Calculate the sum of both numbers
            // 计算两个数字的和
            result = num1 + num2;

            // Display the result to the user
            // 向用户显示结果
            System.out.println("The result is: " + result);
            // 结果是:
        }catch (InputMismatchException e){
            // Step 2: Catch block - handles InputMismatchException if it occurs
            // 步骤2: Catch块 - 如果发生InputMismatchException则处理
            // Error message shown when user enters non-integer input
            // 当用户输入非整数时显示的错误消息

            // 请输入整数作为输入
            System.out.println("请输入整数");
        }

    }

}
