package problem_solving;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sort_Baekjoon_11652 {
    static TreeMap<Long, Integer> count = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=0 ; i < num ; i++){
            Long n = Long.parseLong(br.readLine());
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        ArrayList<Integer> lists = new ArrayList<>(count.values());

        for(Integer val : lists){
            if( max < val){
                max = val;
            }
        }


        PriorityQueue<Long> q = new PriorityQueue<>();
        for(Long key : count.keySet()){
            if(max == count.get(key)){
                q.add(key);
            }
        }

        System.out.println(q.poll());
    }

}
