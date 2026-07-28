import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CalendarPrinter printer = new CalendarPrinter();
        EventManager eventManager = new EventManager();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("      COMMAND LINE CALENDAR");
            System.out.println("====================================");
            System.out.println("1. Display Month Calendar");
            System.out.println("2. Display Year Calendar");
            System.out.println("3. Check Leap Year");
            System.out.println("4. Find Day of Week");
            System.out.println("5. Add Event");
            System.out.println("6. View Events");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter month (1-12): ");
                    int month = sc.nextInt();

                    System.out.print("Enter year: ");
                    int year = sc.nextInt();

                    printer.printMonth(month, year);
                    break;

                case 2:

                    System.out.print("Enter year: ");
                    int fullYear = sc.nextInt();

                    printer.printYear(fullYear);
                    break;

                case 3:

                    System.out.print("Enter year: ");
                    int leapYear = sc.nextInt();

                    if (DateUtil.isLeapYear(leapYear))
                        System.out.println(leapYear + " is a Leap Year.");
                    else
                        System.out.println(leapYear + " is NOT a Leap Year.");

                    break;

                case 4:

                    System.out.print("Enter day: ");
                    int day = sc.nextInt();

                    System.out.print("Enter month: ");
                    int m = sc.nextInt();

                    System.out.print("Enter year: ");
                    int y = sc.nextInt();

                    String weekDay = DateUtil.getDay(day, m, y);

                    System.out.println("Day : " + weekDay);

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter date (dd-mm-yyyy): ");
                    String date = sc.nextLine();

                    System.out.print("Enter event: ");
                    String event = sc.nextLine();

                    eventManager.addEvent(date, event);

                    break;

                case 6:

                    eventManager.viewEvents();

                    break;

                case 7:

                    System.out.println("Thank you for using Calendar.");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}