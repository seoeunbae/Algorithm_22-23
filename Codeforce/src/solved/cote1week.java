package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class cote1week {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = Integer.valueOf(scanner.nextLine());
        List<Integer> stack = new ArrayList<>();
        for(int i=0;i < N; i++){
            Func(scanner.nextLine(), stack);
        }
    }

    public static void Func(String command, List<Integer> stack){
        String[] splits = command.split(" ");

        if(splits.length==2){
            if(splits[0].equals("push")){
                stack.add(Integer.valueOf(splits[1]));
            }
        } else if(splits.length==1){
            if(splits[0].equals("top")){
                System.out.println(stack.get(0));
            } else if(splits[0].equals("size")){
                System.out.println(stack.size());
            } else if(splits[0].equals("empty")){
                if(stack.isEmpty()) System.out.println("1");
                else System.out.println( 0);
            } else if(splits[0].equals("pop")){
                if(stack.isEmpty()) System.out.println(-1);;
                System.out.println(stack.remove(stack.size()));
            }
        }
    }
}
