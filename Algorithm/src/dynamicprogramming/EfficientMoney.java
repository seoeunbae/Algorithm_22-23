package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EfficientMoney {
    static int[] k;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        k = new int[N];
        dp = new int[M+1];

        for(int i=0 ; i< M+1 ; i++){
            dp[i] = 10001;
        }
        for(int i=0 ; i < N ; i++){
            k[i] = Integer.parseInt(br.readLine());
        }
        //k=[2,3] 0...N-1
        dp[0] = 0;
        for(int i=0 ; i < N ; i++){
            for(int j=k[i]; j < M+1 ;j++){
                if(dp[j-k[i]] != 10001){
                    dp[j] = Math.min(dp[j] , dp[j-k[i]] + 1);
                }
            }
        }

        if(dp[M] == 10001){
            System.out.println(-1);
        } else System.out.println(dp[M]);

    }

}
