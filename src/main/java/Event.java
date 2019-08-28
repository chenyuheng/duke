import java.util.Date;

public class Event extends Task {
    protected Date at;

    public Event(String description, Date at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String dataString() {
        return "E | " + (this.isDone ? 1 : 0) + " | " + this.description + " | " + this.at;
    }
}
