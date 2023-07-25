package solved;

import java.util.*;
import java.io.*;

public class Baekjoon_1182 {
    static int N ;
    static int S;
    static boolean[] visited;

    static int totalCount =0;

    static int[] array;

    //static ArrayList<Integer> sumList =new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        array = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i < N ; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        calculate(0,0);
        System.out.println(totalCount);
    }

    public static void calculate(int index, int sum){
        if (index >= N) {
            return;
        }


        if (sum == S) {
            totalCount += 1;
        }

        for(int i = index ; i < N ; i++){
            if (visited[i]) continue;
            visited[i] = true;
            sum += array[index];
            calculate(i+1,  sum);
//            sum -= array[index];
            visited[i] = false;
        }

    }

}
