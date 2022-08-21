package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2161 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> que = new LinkedList<>();

        for(int i=1;i<=N;i++) que.add(i);

        String a = "";
        while (que.size()!=1){
            a+=que.poll().toString()+" ";
            que.add(que.poll());
        }
        System.out.println(a+que.poll());
    }
}

