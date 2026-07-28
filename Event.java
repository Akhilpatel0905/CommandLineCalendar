public class Event {

    private String date;
    private String title;

    // Default Constructor
    public Event() {
    }

    // Parameterized Constructor
    public Event(String date, String title) {
        this.date = date;
        this.title = title;
    }

    // Getter for date
    public String getDate() {
        return date;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Used while saving to file
    @Override
    public String toString() {
        return date + "|" + title;
    }
}