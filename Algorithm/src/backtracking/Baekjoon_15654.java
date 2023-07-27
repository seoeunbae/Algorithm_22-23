package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Baekjoon_15654 {
    static StringTokenizer st;
    static int[] array;
    static int[] eachArray;
    static boolean[] visited;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        eachArray = new int[M];
        visited= new boolean[N];


        st= new StringTokenizer(br.readLine());
        for(int i=0 ; i < N ; i++){
           array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        permutation(0,0, eachArray);
    }

    public static void permutation(int prev, int level, int[] eachArray){
        if (level == M){
            for(int each : eachArray){
                System.out.print(each+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0 ; i < N; i++){
            if (!visited[i]){
                visited[i] = true;
                eachArray[level] = array[i];
                permutation(i,level+1, eachArray);
                visited[i] = false;
            }
        }

    }
}
