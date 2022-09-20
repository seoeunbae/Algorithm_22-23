package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1715 {

    static Integer temp = 0;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num  = Integer.valueOf(br.readLine());
        queue = new PriorityQueue<>();
        for(int i=0 ; i < num ; i++){
            queue.add(Integer.valueOf(br.readLine()));
        }
        System.out.println(Func(queue, num));

    }

    public static Integer Func(PriorityQueue<Integer> queue, Integer num){
        int[] array = new int[num-1];
        while(num-- > 1){
                temp = queue.poll()+ queue.poll(); // 10 + 20
                array[num-1] = temp;
                queue.add(temp);
        }
       return Arrays.stream(array).sum();
    }
}
