import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarPrinter {

    // Prints a single month's calendar
    public void printMonth(int month, int year) {

        if (month < 1 || month > 12) {
            System.out.println("Invalid month.");
            return;
        }

        LocalDate firstDay = LocalDate.of(year, month, 1);

        int totalDays = firstDay.lengthOfMonth();

        // Monday = 1 ... Sunday = 7
        int firstDayValue = firstDay.getDayOfWeek().getValue();

        System.out.println();
        System.out.println("======================================");
        System.out.println("        " + Month.of(month) + " " + year);
        System.out.println("======================================");

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        // Print leading spaces
        for (int i = 1; i < firstDayValue; i++) {
            System.out.printf("%4s", "");
        }

        // Print all dates
        for (int day = 1; day <= totalDays; day++) {

            System.out.printf("%4d", day);

            if ((day + firstDayValue - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
    }

    // Prints all 12 months
    public void printYear(int year) {

        System.out.println();
        System.out.println("======================================");
        System.out.println("          YEAR : " + year);
        System.out.println("======================================");

        for (int month = 1; month <= 12; month++) {

            printMonth(month, year);

        }

    }

}