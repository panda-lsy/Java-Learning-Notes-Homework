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

class Manager extends Employee{
    //Create Manager attributes teamSize 创建 Manager 属性 teamSize
    int teamSize;
    //Constructor for Manager class to intialise variables of Manager class and parent class Employee when an object is created - Manager 类的构造函数，用于在创建对象时初始化 Manager 类和父类 Employee 的变量
    //call the Employee(Parent) class constructor to Intialise Employee Class variables name, age, department and salary. 调用 Employee（父）类构造函数以初始化 Employee 类变量 name、age、department 和 salary。
    Manager(String name,int age,int salary,String department,int teamSize){
        //use super key word to call Parent class constructor 使用 super 关键字调用父类构造函数
        super(name, age, salary, department);
        this.teamSize = teamSize;
    }

    //Create method to Display details of Manager only display team size 创建一个方法以显示 Manager 的详细信息，仅显示团队规模
    public void displayTeamSize(){
        displayemployee();
        System.out.println("TeamSize:"+teamSize);
    }

    //Create method to display manager bonus (10% of annual salary) 创建一个方法以显示经理的奖金（年薪的 10%）
    public double managerBonus(){
        double bonus = annualSalary()*0.1;
        return bonus;
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("John",18,6000,"IT");
        e1.displayemployee();
        System.out.println("Annual Salary:"+e1.annualSalary());

        Manager m1 = new Manager("God",30,12000,"IT",20);
        m1.displayTeamSize();
        System.out.println("Manager Bonus:"+m1.managerBonus());
    }
}
