package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_11057 {
    static int[][] Dy;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Dy = new int[N+1][10];
        func(N);
    }

    public static void func(int N){
        Dy[0][0] = 0;
        if(N == 1){
            Arrays.fill(Dy[1], 1);
        }
        for(int len = 2 ; len <= N ; len++){
            for(int num  =0 ; num <= 9 ; num++){
                for(int prev =0 ; prev <= num ; prev++){
                    Dy[len][num] += Dy[len-1][prev];
                    Dy[len][num] %= 10007;
                }
            }
        }

        int ans = 0;
        for(int num = 0 ; num <= 9 ; num++){
            ans += Dy[N][num];
        }
        System.out.println(ans);
    }
}
