package Chapter05;

class Person{
    String name;
    int age;

    public void display(){
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
    }


    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
}
class Employee extends Person{
    int salary;
    String department;

    Employee(String name,int age,int salary,String department){
        super(name,age);
        this.salary = salary;
        this.department = department;
    }

    public int annualSalary(){
        int annualsalary=12*salary;
        return annualsalary;
    }

    public void displayemployee() {
        display();
        System.out.println("Salary:"+salary);
        System.out.println("Department:"+department);
    }
}
public class SingleInheritancenoCunstructor {
    public static void main(String[] args) {
        Employee e1 = new Employee("John",18,6000,"IT");
        e1.displayemployee();
        System.out.println("Annual Salary:"+e1.annualSalary());
    }
}
