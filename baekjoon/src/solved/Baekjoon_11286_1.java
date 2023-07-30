package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_11286_1 {
    //우선순위큐 로 힙구현 하기
    static PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o1)-Math.abs(o2) == 0) return o1-o2;
            else return Math.abs(o1)-Math.abs(o2);
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            int num = Integer.parseInt(br.readLine());
            solution(num);
        }
    }

    public static void solution(int num){
        if(num == 0){
            Integer polled = heap.poll();
            if(polled == null) polled = 0;
            System.out.println(polled);
        } else heap.add(num);
    }


}
