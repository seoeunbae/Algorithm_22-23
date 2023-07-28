package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15655 {
    static StringTokenizer st;
    static int N;
    static int M;
    static int[] array;
    static boolean[] visited;
    static int[] eachArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        eachArray = new int[M];
        visited= new boolean[N];

    }
}
