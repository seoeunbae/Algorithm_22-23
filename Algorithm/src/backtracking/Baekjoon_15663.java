package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baekjoon_15663 {
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
        permutation(0, temp);
//        print(set);
        System.out.println(sb.toString());
    }

    public static void permutation(int level, int[] temp){
        if (level== M){
            print(temp);
            return;
        }
        int prevEle = 0;
        for(int j = 0; j < N ; j++){
            if (!visited[j]) {
                if (prevEle != array[j]) {
                    visited[j] = true;
                    temp[level] = array[j];
                    prevEle = temp[level];
                    permutation(level + 1, temp);
                    visited[j] = false;
                }
            }
        }
    }

    public static void print(int[] temp){
        for(int ele : temp){
            sb.append(ele).append(" ");
        }
        sb.append("\n");
    }
}
