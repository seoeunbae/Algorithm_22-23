package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusOneTwoThree05 {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


             dp = new long[100001][4];

            dp[1][1] = dp[2][2] = dp[3][3] = dp[3][1] = dp[3][2] = 1;

            for(int j = 4 ; j <= 100000 ; j++ ){
                dp[j][1] = (dp[j-1][2] + dp[j-1][3]) % 1000000009;
                dp[j][2] = (dp[j-2][1] + dp[j-2][3]) % 1000000009 ;
                dp[j][3] = (dp[j-3][1] + dp[j-3][2]) % 1000000009 ;
            }



                for(int i=0 ; i < t ; i++)

    {

        Integer N = Integer.parseInt(br.readLine());

        sb.append((dp[N][1] + dp[N][2] + dp[N][3]) % 1000000009);
        sb.append("\n");


    }
        System.out.println(sb.toString());
    }
}
