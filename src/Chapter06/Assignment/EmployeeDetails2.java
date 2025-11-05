package Chapter06.Assignment;

import java.util.Scanner;

class Employee1{
    String name,contact;
    int age;
    public Employee1(String name, String contact, int age){
        this.name = name;
        this.contact = contact;
        this.age = age;
    }
}

class InvalidValueError extends RuntimeException{
    public InvalidValueError(int age){
        super("Invalid Value: "+age);
        System.out.println("Invalid Value: "+age);
    }
}

public class EmployeeDetails2 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String contact = sc.nextLine();
        int age = sc.nextInt();
        Employee1 e1 = new Employee1(name, contact, age);
        try{
            if (e1.age<20||e1.age>55){
                throw new InvalidValueError(age);
            }
        }catch (InvalidValueError e){
            System.out.println(e.getMessage());
        }

    }
}
