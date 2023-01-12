package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Permutation_15654 {
    static int[] numbers;

    static int N,M;

    static int[] result;
    static boolean[] visited;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);

        numbers = new int[N];
        visited = new boolean[N+1];
        result = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0 ; i < N ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        permutation(0);
    }

    public static void permutation( int M ){
        if(M == 0) {
           for (int i=0 ; i < result.length ; i++){
               System.out.println(result[i]+" ");
           }
            System.out.println();
        } else {
            for(int i=0 ; i < N ; i++){
                if( !visited[i] ){
                    visited[i] = true;
                    result[M]= numbers[i];
                    permutation(M+1);

                    visited[i] = false;
                }
            }
        }
    }
}
