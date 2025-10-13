package Chapter04.Practice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class weekendChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (yyyy-mm-dd):");
        String raw = sc.nextLine();
        LocalDate date = LocalDate.parse(raw);
        DayOfWeek day = date.getDayOfWeek();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy",Locale.US);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE", Locale.US);
        if (day==DayOfWeek.SUNDAY||day==DayOfWeek.SATURDAY){
            System.out.println(formatter.format(date)+" is a "+formatter2.format(date)+" - Weekend!");
        }else{
            System.out.println(formatter.format(date)+" is a "+formatter2.format(date)+" - Weekday");
        }



    }
}
