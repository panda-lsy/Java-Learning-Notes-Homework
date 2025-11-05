package Chapter06.Assignment;

import java.util.Objects;
import java.util.Scanner;

class Employee {
    String id;
    String name;
    String department;
    String designation;
    String dateOfJoining;
    String dateOfBirth;
    boolean isMarried;
    String dateOfMarriage;

    public void enterData(){
        Scanner sc = EmployeeDetails.sc;
        System.out.print("ID:");
        id = sc.nextLine();
        if (id.length() == 0 || id.charAt(0) == 'e'){
            throw new MismatchedInputError(id);
        }
        System.out.print("Name:");
        name = sc.nextLine();
        System.out.print("Department:");
        department = sc.nextLine();
        System.out.print("Designation:");
        designation = sc.nextLine();
        System.out.print("DateOfJoining:");
        dateOfJoining = sc.nextLine();
        System.out.print("dateOfBirth:");
        dateOfBirth = sc.nextLine();
        System.out.print("isMarried(true/false):");
        if (!sc.hasNextBoolean()) {
            String bad = sc.nextLine();
            throw new MismatchedInputError(bad);
        }
        isMarried = sc.nextBoolean();
        sc.nextLine();
        if (isMarried){
            System.out.print("dateOfMarriage:");
            dateOfMarriage = sc.nextLine();
        }
    }

    public String toString() {
        return "ID: " + id + "\n姓名: " + name + "\n部门: " + department +
                "\n职位: " + designation + "\n入职日期: " + dateOfJoining +
                "\n出生日期: " + dateOfBirth + "\n婚姻状况: " + (isMarried ? "已婚" : "未婚") +
                (isMarried ? "\n结婚日期: " + dateOfMarriage : "");
    }
}

class InvalidChoiceError extends RuntimeException{
    public InvalidChoiceError(int choice){
        super("Invalid Choice: "+choice);
        System.out.println("Invalid Choice: "+choice);
    }
}

class MismatchedInputError extends RuntimeException{
    public MismatchedInputError(String ID){
        super("Invalid input: "+ID);
        System.out.println("Invalid input: "+ID);
    }
}

public class EmployeeDetails {
    public static Scanner sc = new Scanner(System.in);
    public static int exitState = 0;
    public static Employee [] es = new Employee[50];
    public static int count = 0;
    public static void displayMenu() {
        System.out.println("1. Enter Data");
        System.out.println("2. Display Data");
        System.out.println("3. Exit");
    }

    public static void enterData() {
        es[count] = new Employee();
        es[count].enterData();
        count+=1;
    }

    public static void displayData() {
        System.out.print("请输入ID:");
        String inputID = sc.nextLine();
        for (Employee e : es) {
            if (e != null && Objects.equals(inputID, e.id)) {
                System.out.println(e.toString());
                return;
            }
        }
        System.out.println("未找到对应ID的员工。");
    }

    public static void exitMenu() {
        exitState = 1;
    }

    public static void main(String[] args) {
        while (true) {
            try {
                // 每次启动（或重启）都初始化应用状态
                exitState = 0;
                es = new Employee[50];
                count = 0;
                sc = new Scanner(System.in);

                do {
                    displayMenu();
                    System.out.println("Please enter your choice:");
                    if (!sc.hasNextInt()) {
                        String bad = sc.nextLine();
                        throw new InvalidChoiceError(-1);
                    }
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice){
                        case 1:
                            enterData();
                            break;
                        case 2:
                            displayData();
                            break;
                        case 3:
                            exitMenu();
                            break;
                        default:
                            throw new InvalidChoiceError(choice);
                    }
                } while (exitState == 0);

                System.out.println("程序正常退出。");
                break; // 正常退出，不再重启
            } catch (RuntimeException e) {
                System.out.println("发生异常: " + e.getMessage());
                System.out.println("应用程序重新启动...");
                // 循环继续，外层 while 会重新初始化并重启应用
            }
        }
    }
}
