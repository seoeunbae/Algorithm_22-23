package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_1427 {
    static PriorityQueue<Integer> sortingHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1; //오름차순
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split("");
        int[] numbers = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            sortingHeap.add(number);
        }
        solution();
    }

    public static void solution(){
        while(!sortingHeap.isEmpty()){
            System.out.print(sortingHeap.poll());
        }
    }

}
