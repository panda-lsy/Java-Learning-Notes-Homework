package Chapter04.Assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateOfBirth {
    public static void main(String[] args) {
        LocalDate birthday = LocalDate.now();
        birthday = birthday.plusDays(1).minusYears(30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Date of Birth:"+ formatter.format(birthday));

    }
}
