import java.util.Scanner;
import java.util.ArrayList;
public class Duke {
    public static void main(String[] args) {
        answer("Hello! I'm Duke\nWhat can I do for you?");
        Scanner in=new Scanner(System.in);
        ArrayList<Task> taskList=new ArrayList<Task>();
        while(true){
            String input=in.nextLine();
            if(input.equals("list")){
                String output="";
                for(int i=0;i<taskList.size()-1;i++)
                    output+=i+1+"."+taskList.get(i)+"\n";
                output+=taskList.size()+"."+taskList.get(taskList.size()-1);
                answer(output);
                continue;
            }else if(input.equals("bye")){
                answer("Bye. Hope to see you again soon!");
                break;
            }else if(input.length()>=4){
                if(input.substring(0,4).equals("done")){
                    taskList.get(Integer.parseInt(input.substring(5))-1).markAsDone();
                    answer("Nice! I've marked this task as done: \n"+taskList.get(Integer.parseInt(input.substring(5))-1));
                    continue;
                }
            }
            taskList.add(new Task(input));
            answer("added: "+input);

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
