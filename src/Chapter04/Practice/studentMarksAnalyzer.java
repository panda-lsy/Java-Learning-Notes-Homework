package Chapter04.Practice;

import java.util.Arrays;

public class studentMarksAnalyzer {
    public static void main(String[] args) {
        int [] marks = {75,82,90,65,88};
        Arrays.sort(marks);
        int highest = marks[0];
        int lowest = marks[4];
        float sum = 0;
        for (int num : marks){
            sum += num;
        }
        float average = sum/5;
        System.out.println("Marks:"+ Arrays.toString(marks));
        System.out.println("Highest:"+ highest);
        System.out.println("Lowest:"+ lowest);
        System.out.print("Average:");
        System.out.printf("%.1f",average);
    }
}
