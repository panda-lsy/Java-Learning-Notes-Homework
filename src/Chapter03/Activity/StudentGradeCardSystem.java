package Chapter03.Activity;

class Student{
    String name;
    int marks;
    String grade;
    void calculateGrade(){
        if(marks >= 90){
            grade = "A";
        } else if(marks >= 80){
            grade = "B";
        } else if(marks >= 70){
            grade = "C";
        } else if(marks >= 60){
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Student: " + name + ", Marks: " + marks + ", Grade: " + grade);
    }
}

public class StudentGradeCardSystem {
    public static void main(String[] args) {
        Student student1=new  Student();
        student1.name="Zhang Wei";
        student1.marks=88;
        student1.calculateGrade();
        Student student2=new  Student();
        student2.name="Li Mei";
        student2.marks=55;
        student2.calculateGrade();
    }
}

