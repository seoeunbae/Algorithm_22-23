package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_2075 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringTokenizer line;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());
        line = new StringTokenizer(br.readLine());

        for(int i=0 ; i < num ; i++){
            Integer integer = Integer.valueOf(line.nextToken());
            pq.add(integer);
        }

        for(int i=1 ; i < num ; i++){
            line = new StringTokenizer(br.readLine());
            for(int j=0; j<num ; j++){
                Integer integer = Integer.valueOf(line.nextToken());
                if(pq.peek() < integer){
                    pq.poll();
                    pq.add(integer);
                }
            }

        }
        System.out.println(pq.poll());


    }

}
