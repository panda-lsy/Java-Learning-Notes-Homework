package Chapter03.Practice;

import java.util.Scanner;

public class AcademicSummaryGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your name:");
        String name = sc.next();
        System.out.println("Subject A Grade:");
        double gradeA = sc.nextDouble();
        System.out.println("Subject B Grade:");
        double gradeB = sc.nextDouble();
        System.out.println("Subject C Grade:");
        double gradeC = sc.nextDouble();
        System.out.println("Subject D Grade:");
        double gradeD = sc.nextDouble();
        System.out.println("Subject E Grade:");
        double gradeE = sc.nextDouble();
        double sum = gradeA + gradeB + gradeC + gradeD + gradeE;
        double average = sum/5;
        System.out.println("Name:"+name);
        System.out.println("Total Grade:"+sum);
        System.out.println("Average Grade:"+average);
        if(average>=90){
            System.out.println("Grade A");
        } else if (average>=80) {
            System.out.println("Grade B");
        } else if (average>=70) {
            System.out.println("Grade C");
        } else if (average>=60) {
            System.out.println("Grade D");
        } else if (average>=0) {
            System.out.println("Grade F");
        }else{
            System.out.println("Invalid Grade!");
        }
    }
}
