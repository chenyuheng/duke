import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    /***<p>
     * Main method of the entire project.</p>
     * @param args command line arguments
     */
    public static void main(String[] args) {
        answer("Hello! I'm Duke\nWhat can I do for you?");
        Scanner in = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<Task>();
        while (true) {
            String input = in.next();
            if (input.equals("list")) {
                String output = "Here are the tasks in your list:";
                for (int i = 0;i < taskList.size();i++) {
                    output += "\n" + (i + 1) + "." + taskList.get(i);
                }
                answer(output);
                continue;
            } else if (input.equals("bye")) {
                answer("Bye. Hope to see you again soon!");
                break;
            } else if (input.equals("done")) {
                int index;
                String indexstr = in.next();
                try {
                    index = Integer.parseInt(indexstr) - 1;
                } catch (NumberFormatException e) {
                    answer("☹ OOPS!!! The index of task is not in integer number format.");
                    continue;
                }
                try {
                    taskList.get(index).markAsDone();
                } catch (IndexOutOfBoundsException e) {
                    answer("☹ OOPS!!! The index of task is out of range.");
                    continue;
                }
                answer("Nice! I've marked this task as done: \n" + taskList.get(index));
                continue;
            } else if (input.equals("todo")) {
                String line = in.nextLine();
                if (line.isBlank()) {
                    answer("☹ OOPS!!! The description of todo cannot be empty.");
                    continue;
                }
                taskList.add(new ToDo(line));
            } else if (input.equals("event")) {
                String line = in.nextLine();
                if (line.isBlank()) {
                    answer("☹ OOPS!!! The description of event cannot be empty.");
                    continue;
                }
                String[] splites = line.split(" /at ",2);
                try {
                    taskList.add(new Events(splites[0],splites[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    answer("☹ OOPS!!! Please enter the right event time after \" /at \".");
                    continue;
                }
            } else if (input.equals("deadline")) {
                String line = in.nextLine();
                if (line.isBlank()) {
                    answer("☹ OOPS!!! The description of todo cannot be empty.");
                    continue;
                }
                String[] spllites = line.split(" /by ",2);
                try {
                    taskList.add(new Deadline(spllites[0], spllites[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    answer("☹ OOPS!!! Please enter the right deadline time after \" /by \".");
                    continue;
                }
            } else {
                answer("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                continue;
            }
            answer("Got it. I've added this task: \n\t"
                    + taskList.get(taskList.size() - 1) + "\nNow you have " + taskList.size() + " tasks in the list.");
        }
    }

    /***<p>
     * This is a method to print the message Duke said, automatically add
     * horizontal lines and indentations to the original message and print them.
     * A sample output is:
     *     ____________________________________________________________
     *      Hello! I'm Duke
     *      What can I do for you?
     *     ____________________________________________________________</p>
     * @param toPrint the message need to be printed
     */
    public static void answer(String toPrint) {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine);
        toPrint = "\t" + toPrint;
        for (int i = 0;i < toPrint.length();i++) {
            if (toPrint.charAt(i) == '\n') {
                toPrint = toPrint.substring(0, i + 1) + "\t" + toPrint.substring(i + 1, toPrint.length());
            }
        }
        System.out.println(toPrint);
        System.out.println(horizontalLine);
    }
}
