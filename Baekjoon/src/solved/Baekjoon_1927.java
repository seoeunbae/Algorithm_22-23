package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon_1927 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());

        for(int i=0;i<N;i++){
            Integer number = Integer.valueOf(br.readLine());
            Func(number);
        }

    }

    public static void Func(Integer number){
        pq.add(number);
        if(number == 0) {
            System.out.println(pq.peek());
            pq.poll();
        }
    }
}
