package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNum {
    static long[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        dp = new long[N+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        if(N >= 2){
            dp[2][0] = 1;
            dp[2][1] = 0;
        }

        //dp[3] =
        //1...N
        for(int i=3 ; i <= N ; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0]+dp[N][1]);
    }

}
