package Chapter05.Practice;

class Manager extends Chapter05.Practice.Employee{
    private int teamSize;
    public Manager(String employeeID, String employeeName, String department, int workQuality, int productivity, int teamwork, int attendance, int initiative, int teamSize) {
        super(employeeID, employeeName, department, workQuality, productivity, teamwork, attendance, initiative);
        this.teamSize = teamSize;
    }

    @Override
    void displayPerformance() {
        super.displayPerformance();
        System.out.println("Team Size:"+teamSize);
    }
}
class Developer extends Chapter05.Practice.Employee{
    private String codingLanguage;

    public Developer(String employeeID, String employeeName, String department, int workQuality, int productivity, int teamwork, int attendance, int initiative, String codingLanguage) {
        super(employeeID, employeeName, department, workQuality, productivity, teamwork, attendance, initiative);
        this.codingLanguage = codingLanguage;
    }

    @Override
    void displayPerformance(){
        super.displayPerformance();
        System.out.println("Coding Language:"+codingLanguage);
    }
}
public class EmployeePerformanceEvaluationSystemTwo {
    public static void main(String[] args) {
        Manager m1 = new Manager("10","Jeb","IT",99,98,97,96,97,30);
        m1.displayPerformance();
        Developer d1 = new Developer("11","Jeb","IT",99,98,97,96,97,"C++");
        d1.displayPerformance();
    }
}
