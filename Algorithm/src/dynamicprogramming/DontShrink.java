package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DontShrink {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("vvd");
        int T = Integer.parseInt(br.readLine());
        System.out.println("Vvvv");
        for(int i=0 ; i < T ; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            int[][] dp = new int[10][n+1];
            for(int k=0 ; k < 10 ; k++){
                dp[k][1] = 1;
            }
            for(int k=1 ; k <= n; k++){
                dp[0][k] = 1;
            }

            for(int k=2 ; k<10 ; k++){
                for(int j=1 ; j <= n ; j++){
                        dp[k][j] = dp[k][j-1]*k;
                }
            }
            int answer= 0;
            for(int k=0 ; k < 10 ;k++){
                answer += dp[n][k];
            }
            System.out.println(answer);
        }
    }
}
