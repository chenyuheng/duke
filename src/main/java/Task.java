public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ?  "V" : "x"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String dataString() {
        return this.toString();// to be overwroten
    }

    /***<p>
     * parse a line in the data text to an object
     * </p>
     * @param line a line of String to be parsed, without \n last
     * @return a Task object produced by the input line
     */
    public static Task parse(String line) {
        String[] splites = line.split(" \\| ");
        Task temp;
        if (splites[0].equals("T")) {
            temp = new ToDo(splites[2]);
            if (splites[1].equals("1")) {
                temp.markAsDone();
            }
        } else if (splites[0].equals("E")) {
            temp = new Event(splites[2], splites[3]);
            if (splites[1].equals("1")) {
                temp.markAsDone();
            }
        } else if (splites[0].equals("D")) {
            temp = new Deadline(splites[2], splites[3]);
            if (splites[1].equals("1")) {
                temp.markAsDone();
            }
        } else {
            temp = new Task("this task will exit if duke.txt have format error. Original line: " + line);
        }
        return temp;
    }
}
