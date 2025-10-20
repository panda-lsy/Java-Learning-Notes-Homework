package Chapter05.Practice;

class Employee{
    private String employeeID;
    private String employeeName;
    private String department;
    private int workQuality;
    private int productivity;
    private int teamwork;
    private int attendance;
    private int initiative;
    private int totalPerformance;
    private float averagePerformance;

    public  Employee(String employeeID,String employeeName,String department,int workQuality, int productivity,int teamwork,int attendance,int initiative){
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.department = department;
        this.workQuality = workQuality;
        this.productivity = productivity;
        this.teamwork = teamwork;
        this.attendance = attendance;
        this.initiative = initiative;
    }

    int getTotalPerformance(){
        return workQuality+productivity+teamwork+attendance+initiative;
    }

    float getAveragePerformance(){
        totalPerformance = getTotalPerformance();
        return (float) totalPerformance /5;
    }

    void determineRating(){
        averagePerformance = getAveragePerformance();
        System.out.print("Performance Rating:");
        if (averagePerformance>=90){
            System.out.println("Outstanding");
        }else if (averagePerformance>=80){
            System.out.println("Excellent");
        }else if (averagePerformance>=70){
            System.out.println("Good");
        }else if (averagePerformance>=60){
            System.out.println("Satisfactory");
        }else {
            System.out.println("Needs Improvement");
        }
    }

    void displayPerformance(){
        System.out.println("Employee Performance Summary");
        System.out.println("Employee Name:"+employeeName);
        System.out.println("Employee ID:"+employeeID);
        System.out.println("Department:"+department);
        totalPerformance = getTotalPerformance();
        System.out.println("Total Performance Score:"+totalPerformance+"/500");
        averagePerformance = getAveragePerformance();
        System.out.print("Average Performance Score:");
        System.out.printf("%.2f",averagePerformance);
        System.out.println("%");
        determineRating();
    }
}

public class EmployeePerformanceEvaluationSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("202501", "John", "Marketing", 80, 80, 95, 90, 80);
        e1.displayPerformance();
    }
}
