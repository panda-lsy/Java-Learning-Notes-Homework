package Chapter06.Practice;

import java.util.Scanner;

public class StudentAgeandMarksValidator {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        sc.nextLine();
        int marks = sc.nextInt();
        assert (age<=25 && age>=5):"Age must be between 5 and 25";
        assert (marks<=100 && marks>=0):"Marks must be between 0 and 100";
        assert false : "Age and marks must both be valid";
    }
}
