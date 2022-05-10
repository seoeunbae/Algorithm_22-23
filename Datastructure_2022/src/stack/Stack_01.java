package stack;

import java.util.ArrayList;
import java.util.List;

public class Stack_01 {

    public static List push(List stack, Integer number){
            stack.add(number);
            return stack;
    }

    public static List pop(List stack){
        if( stack.isEmpty()){
            return null;
        }
        int length = stack.size();
        stack.remove(length-1);
        return stack;
    }

    public static void main(String[] args) {
        List<Integer> stack = new ArrayList<>();

        push(stack,1);
        System.out.println(stack);
        push(stack, 2);
        System.out.println(stack);
        push(stack,3);
        System.out.println(stack);

        pop(stack);
        System.out.println(stack);
        pop(stack);
        System.out.println(stack);
        pop(stack);
        System.out.println(stack);

    }
}
