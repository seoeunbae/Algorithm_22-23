package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_2750 {
    static PriorityQueue<Integer> sorting = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        for(int i=0 ; i<n ; i++){
            sorting.add(Integer.parseInt(br.readLine()));
        }
        printAnswer();
    }

    public static void printAnswer(){
        while(!sorting.isEmpty()){
            System.out.println(sorting.poll());
        }
    }
}
