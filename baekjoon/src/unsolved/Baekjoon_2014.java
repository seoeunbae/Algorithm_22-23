package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Baekjoon_2014 {
    static StringTokenizer st;
    static PriorityQueue<Integer> pq =new PriorityQueue<>();
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        Integer K = Integer.valueOf(st.nextToken()); // 소수의 개수
        Integer N = Integer.valueOf(st.nextToken()); // 몇번째 수
        st = new StringTokenizer(br.readLine());
        arr = new int[K];
        for(int i=0 ; i < K ; i++){
            int temp = Integer.parseInt(st.nextToken());
            pq.add(temp);
            arr[i] = temp;
        }
        int answer = 0;

        for(int i=0; i<N-1 ; i++){
            answer = pq.poll();
            for( int z=0 ; z<K ; z++){
//                if((answer * arr[i]))){
//                    break;
//                }
                pq.add( arr[z] * answer);
                if(answer % arr[z] == 0) {
                    break;
                }
            }

        }
        System.out.println(pq.poll());
    }

}
