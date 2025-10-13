package Chapter04.Practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class rentalDueDateCalculator {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.now();
        LocalDate dueDate = startDate.plusDays(14);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd,yyyy", Locale.US);
        System.out.println("Rental Start Date:"+startDate);
        System.out.println("Due Date:"+formatter.format(startDate));
    }

}
