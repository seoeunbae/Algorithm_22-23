package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11050 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);//5
        int K = Integer.parseInt(inputs[1]);//2

        dp = new int [N+1][K+1];
        System.out.println(Factorial(N,K));
    }

    public static int Factorial(int N, int K){
        if(dp[N][K] > 0){
            return dp[N][K];
        }

        if(N==K || K==0){
            return dp[N][K] = 1;
        }

        return dp[N][K] = Factorial(N-1,K-1) + Factorial(N-1, K);
    }
}
