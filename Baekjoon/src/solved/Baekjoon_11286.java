package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon_11286 {
    static PriorityQueue<Integer> minusHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> plusHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        for(int i=0 ; i<N ; i++){
            Integer number = Integer.valueOf(br.readLine());
            Func(number);
        }


    }

    public static void Func(Integer number){
        if(number<0) minusHeap.add(number);
        else if(number>0) plusHeap.add(number);

        else {
//            System.out.println("peek: " + minusHeap.peek());
//            System.out.println("peek/plus : " + plusHeap.peek());
            if( minusHeap.peek()== null && plusHeap.peek() == null) System.out.println(0);
            else if(minusHeap.peek()==null) {
                System.out.println(plusHeap.poll());
            } else if( plusHeap.peek() == null){
                System.out.println(minusHeap.poll());
            } else if(Math.abs(minusHeap.peek()) > plusHeap.peek()) {
                System.out.println(plusHeap.poll());
//                plusHeap.poll();
            } else if( Math.abs(minusHeap.peek()) == minusHeap.peek()){
                System.out.println(minusHeap.poll());
//                minusHeap.poll();
            } else{
                System.out.println(minusHeap.poll());
//                minusHeap.poll();
            }
        }
    }



}
