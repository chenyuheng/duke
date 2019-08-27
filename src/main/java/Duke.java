import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        answer("Hello! I'm Duke\nWhat can I do for you?");
        Scanner in=new Scanner(System.in);
        String[] list=new String[100];
        int listlength=0;
        while(true){
            String input=in.nextLine();
            if(input.equals("list")){
                String output="";
                for(int i=0;i<listlength-1;i++)
                    output+=i+1+". "+list[i]+"\n";
                output+=listlength+". "+list[listlength-1];
                answer(output);
            }else if(input.equals("bye")){
                answer("Bye. Hope to see you again soon!");
                break;
            }else {
                list[listlength++]=input;
                answer("added: "+input);
            }
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
