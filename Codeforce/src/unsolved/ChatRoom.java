package unsolved;

import java.util.Scanner;

public class ChatRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Func(scanner.nextLine()));
    }

    public static String Func(String string){
        int j=0, pas=0;
        String[] splits = string.split("");
        String[] hello = {"h","e","l","l","o"};
        for(int i=0; i< splits.length; i++){
            if(splits[i].equals(hello[j])){
                j++;
                pas++;
                if(pas==5){
                    break;
                }
            }
        }
        if(pas ==5){
            return "YES";
        }else{
            return "NO";
        }
    }
}
