package Chapter02.Practice;

public class StudentMarksCalculator {
    public static void main(String[] args) {
        String StudentName = "Sarah";
        int MarksEnglish = 85;
        int MarksMath = 92;
        int MarksScience = 78;
        int MarksSocialStudies = 88;
        int Language = 80;
        int TotalMarks = MarksEnglish + MarksMath + MarksScience + MarksSocialStudies + Language;
        double Percentage = (TotalMarks / 500.0) * 100;
        System.out.println("Student Name: " + StudentName);
        System.out.println("Total Marks: " + TotalMarks);
        System.out.printf("Percentage: %.2f%%\n", Percentage);
    }
}
