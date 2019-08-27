import java.util.Scanner;
import java.util.ArrayList;
public class Duke {
    public static void main(String[] args) {
        answer("Hello! I'm Duke\nWhat can I do for you?");
        Scanner in=new Scanner(System.in);
        ArrayList<Task> taskList=new ArrayList<Task>();
        while(true){
            String input=in.next();
            if(input.equals("list")){
                String output="Here are the tasks in your list:\n";
                for(int i=0;i<taskList.size()-1;i++)
                    output+=i+1+"."+taskList.get(i)+"\n";
                output+=taskList.size()+"."+taskList.get(taskList.size()-1);
                answer(output);
                continue;
            }else if(input.equals("bye")){
                answer("Bye. Hope to see you again soon!");
                break;
            }else if(input.equals("done")){
                int index=Integer.parseInt(in.next())-1;
                taskList.get(index).markAsDone();
                answer("Nice! I've marked this task as done: \n"+taskList.get(index));
                continue;
            }else if(input.equals("todo")){
                String line=in.nextLine();
                taskList.add(new ToDo(line));
            }else if(input.equals("event")){
                String line=in.nextLine();
                String[] splites=line.split(" /at ",2);
                taskList.add(new Events(splites[0],splites[1]));
            }else if(input.equals("deadline")){
                String line=in.nextLine();
                String[] spllites=line.split(" /by ",2);
                taskList.add(new Deadline(spllites[0],spllites[1]));
            }
            answer("Got it. I've added this task: \n\t"+taskList.get(taskList.size()-1)+"\nNow you have "+taskList.size()+" tasks in the list.");

        }
    }
    public static void answer(String toPrint){
        String horizontalLine="\t____________________________________________________________";
        System.out.println(horizontalLine);
        toPrint="\t"+toPrint;
        for(int i=0;i<toPrint.length();i++){
            if(toPrint.charAt(i)=='\n') {
                //System.out.println(toPrint.length()+" "+i+toPrint.substring(0, i) + "," + toPrint.substring(i, toPrint.length())+".");
                toPrint = toPrint.substring(0, i+1) + "\t" + toPrint.substring(i+1, toPrint.length());

            }
        }
        System.out.println(toPrint);
        System.out.println(horizontalLine);

    }
}
