package Chapter06.Practice;

import java.util.Scanner;

public class StudentAgeRegistration{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String studentAge = "fifteen"; // Student wrote age as word
        // 学生用文字写年龄
        // This line causes NumberFormatException
        // 这行代码会导致NumberFormatException
        // ParseInt-Converting String to integer
        // ParseInt-将字符串转换为整数
        while (true) {
            try {
                int age = Integer.parseInt(studentAge);
                System.out.println("Student age: " + age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Format, Please Input again:");
                studentAge = sc.nextLine();
            }
        }
    }
}