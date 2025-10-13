package Chapter04.Practice;

import java.io.BufferedReader;
import java.util.Scanner;

enum Days{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class dayoftheWeekPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw = sc.next();
        Days inputDay = Days.valueOf(raw);
        switch (inputDay){
            case MONDAY :
                System.out.println("Work day");
                break;
            case TUESDAY:
                System.out.println("Work day");
                break;
            case THURSDAY:
                System.out.println("Work day");
                break;
            case FRIDAY:
                System.out.println("Work day");
                break;
            case WEDNESDAY:
                System.out.println("Weekend relaxation");
                break;
            case SUNDAY:
                System.out.println("Family time");
                break;
        }
    }
}
