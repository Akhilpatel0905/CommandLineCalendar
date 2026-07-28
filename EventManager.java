import java.io.*;

public class EventManager {

    private static final String FILE_NAME = "events.txt";

    // Add an event to the file
    public void addEvent(String date, String title) {

        Event event = new Event(date, title);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(event.toString());
            writer.newLine();

            System.out.println("\nEvent added successfully.");

        } catch (IOException e) {

            System.out.println("Error saving event.");

        }

    }

    // Display all events
    public void viewEvents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("\nNo events found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n===============================");
            System.out.println("       SAVED EVENTS");
            System.out.println("===============================");

            boolean found = false;

            while ((line = reader.readLine()) != null) {

                found = true;

                String[] data = line.split("\\|");

                if (data.length == 2) {

                    Event event = new Event(data[0], data[1]);

                    System.out.println("Date  : " + event.getDate());
                    System.out.println("Event : " + event.getTitle());
                    System.out.println("-------------------------------");

                }

            }

            if (!found) {
                System.out.println("No events available.");
            }

        } catch (IOException e) {

            System.out.println("Error reading events.");

        }

    }

}