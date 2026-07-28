import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;

public class DateUtil {

    // Check if a year is leap year
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    // Return the day of the week
    public static String getDay(int day, int month, int year) {

        if (!isValidDate(day, month, year)) {
            return "Invalid Date";
        }

        LocalDate date = LocalDate.of(year, month, day);

        return date.getDayOfWeek().toString();
    }

    // Validate a date
    public static boolean isValidDate(int day, int month, int year) {

        try {
            LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }

    }

    // Number of days in a month
    public static int getDaysInMonth(int month, int year) {

        if (month < 1 || month > 12)
            return -1;

        return LocalDate.of(year, month, 1).lengthOfMonth();

    }

    // Compare two dates
    public static int compareDates(int d1, int m1, int y1,
                                   int d2, int m2, int y2) {

        LocalDate date1 = LocalDate.of(y1, m1, d1);
        LocalDate date2 = LocalDate.of(y2, m2, d2);

        return date1.compareTo(date2);

    }

}