package Chapter05.Practice;

class Student{
    private final String name;
    private final String rollNumber;
    private final int [] marks;
    private float totalMark;
    private float averageMark;
    private String grade;
    public Student(String name,String rollNumber,int [] marks){
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    void checkValidMarks(){
        for (int mark : marks){
            if (mark<0 || mark>100){
                System.out.println("Invalid Mark!"+mark);
                break;
            }
        }
        System.out.println("Check Passed!");
    }
    float getTotalMark(){
        for (int mark : marks) {
            totalMark += mark;
        }
        return totalMark;
    }
    float calculateAverage(){
        totalMark = getTotalMark();
        return totalMark/5;
    }
    void calculateGrade(){
        averageMark = calculateAverage();
        if(averageMark >= 90){
            grade = "A";
        } else if(averageMark >= 80){
            grade = "B";
        } else if(averageMark >= 70){
            grade = "C";
        } else if(averageMark >= 60){
            grade = "D";
        } else {
            grade = "F";
        }
    }
    void displayReportCard(){
        System.out.println("Student Name:"+name);
        System.out.println("Roll Number:"+rollNumber);
        totalMark = getTotalMark();
        System.out.println("Total Marks:"+totalMark);
        System.out.print("Average Percentage:");
        averageMark = calculateAverage();
        System.out.printf("%.2f\n",averageMark);
        calculateGrade();
        System.out.println("Grade Assigned:"+grade);
    }
}

public class StudentReportCardSystem {
    public static void main(String[] args) {
        Student student1=new Student("Wang","2024120100", new int[]{60, 61, 62, 63, 64});
        student1.checkValidMarks();
        student1.displayReportCard();
    }
}

