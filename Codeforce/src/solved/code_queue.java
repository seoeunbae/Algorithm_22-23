package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class code_queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer integer = Integer.valueOf(scanner.nextLine());
        Func(integer);
    }

    public static void Func(Integer integer){
        List<Integer> queue = new ArrayList<>();

        for(int i=1;i <= integer;i++){
            queue.add(i);
        }
        System.out.println(queue);

        while(queue.size()>1){
            System.out.printf(String.valueOf(queue.remove(0)));
            System.out.println(" ");
            Collections.swap(queue, 0, queue.size()-1);
        }

        System.out.println(queue.get(0));

    }
}
