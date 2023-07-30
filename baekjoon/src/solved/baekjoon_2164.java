package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class baekjoon_2164 {
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution(n);
    }

    public static void solution(int n){
        for(int i=1 ; i<=n ; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            System.out.println("while");
            queue.poll();
            Integer poped = queue.poll();
            queue.add(poped);
        }
        System.out.println(queue.poll());
    }
}
