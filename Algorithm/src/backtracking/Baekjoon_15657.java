package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15657 {
    static int[] temp;
    static int N;
    static int M;
    static StringTokenizer st;
    static boolean[] visited;
    static int[] array;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb= new StringBuilder();
        visited = new boolean[N];
        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i < N ; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        temp = new int[M];
        permutation(0,0, temp);
        System.out.println(sb.toString());
    }

    public static void permutation(int prev, int level, int[] temp){
        if (level== M){
            print(temp);
            return;
        }

        for(int j = prev; j < N ; j++){
            temp[level] = array[j];
            permutation(j, level+1, temp);

        }
    }

    public static void print(int[] temp){
        for(int each : temp){
            sb.append(each).append(" ");
        }
        sb.append("\n");
    }
}
