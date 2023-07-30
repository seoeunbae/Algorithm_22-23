package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer N = Integer.valueOf(scanner.nextLine());
        List<Integer> stack = new ArrayList<>();
        for(int i=0;i < N; i++){
            System.out.println(Func(scanner.nextLine(), stack));;
        }
    }

    public static Integer Func(String command, List<Integer> stack){
        String[] splits = command.split(" ");

        if(splits.length==2){
            if(splits[0].equals("push")){
                stack.add(Integer.valueOf(splits[1]));
            }
        } else if(splits.length==1){
            if(splits[0].equals("top")){
                return stack.get(0);
            } else if(splits[0].equals("size")){
                return stack.size();
            } else if(splits[0].equals("empty")){
                if(stack.isEmpty()) return 1;
                else return 0;
            } else if(splits[0].equals("pop")){
                if(stack.isEmpty()) return -1;
                return stack.remove(0);
            }
        }
        return 0;
    }
}
