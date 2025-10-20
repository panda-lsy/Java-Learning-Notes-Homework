package Chapter04.Assignment;

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

    Scanner sc = new Scanner(System.in);

    public void enterData(){
        System.out.print("ID:");
        id = sc.nextLine();
        System.out.print("Name:");
        name = sc.nextLine();
        System.out.print("Department:");
        department = sc.nextLine();
        System.out.print("Designation:");
        designation = sc.nextLine();
        System.out.print("DateOfJoining");
        dateOfJoining = sc.nextLine();
        System.out.print("dateOfBirth");
        dateOfBirth = sc.nextLine();
        System.out.print("isMarried(true/false):");
        isMarried = sc.nextBoolean();
        sc.nextLine();
        if (isMarried){
            System.out.print("dateOfMarriage");
            dateOfBirth = sc.nextLine();
        }
    }

    public String toString() {
        return "ID: " + id + "\n姓名: " + name + "\n部门: " + department +
                "\n职位: " + designation + "\n入职日期: " + dateOfJoining +
                "\n出生日期: " + dateOfBirth + "\n婚姻状况: " + (isMarried ? "已婚" : "未婚") +
                (isMarried ? "\n结婚日期: " + dateOfMarriage : "");
    }
}

public class employeeBook {
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
                break;
            }
        }
    }

    public static void exitMenu() {
        exitState = 1;
    }

    public static void main(String[] args) {
        Employee [] es = new Employee[50];
        do {
            displayMenu();
            System.out.println("Please enter your choice:");
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
                System.out.println("Invalid choice!");
            }
        } while (exitState == 0);
    }
}
