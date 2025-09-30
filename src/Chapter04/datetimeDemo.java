package Chapter04;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class datetimeDemo {
    public static void main(String[] args) {
        LocalDateTime CurrentDateTime = LocalDateTime.now();
        System.out.println(CurrentDateTime);

        LocalDateTime CustomDateTime=LocalDateTime.of(2024,12,13,12,32,45);
        System.out.println(CustomDateTime);

        System.out.println(CurrentDateTime.getYear());
        System.out.println(CurrentDateTime.getMonth());

        System.out.println("Date and Time After 10 Years:" + CurrentDateTime.plusYears(10));
        System.out.println("Date and Time Before 1 Year:" + CurrentDateTime.minusYears(1));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String n1 = CurrentDateTime.format(df);
        System.out.println(n1);
    }
}
