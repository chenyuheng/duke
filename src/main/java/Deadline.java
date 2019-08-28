import java.util.Date;

public class Deadline extends Task {
    protected Date by;

    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String dataString() {
        return "D | " + (this.isDone ? 1 : 0) + " | " + this.description + " | " + this.by;
    }
}
