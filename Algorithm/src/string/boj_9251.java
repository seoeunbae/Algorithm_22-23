package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9251 {
//최장 공통 부분 문자열 : 떨어져있으면 해당하지않는 경우이다.
//최장 공통 부분 수열 : 떨여져있어도 해당되는 경우이다.

    static BufferedReader in;
    static int max;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0 ; i <= n ; i++){
            for(int j=0 ; j <= m ; j++){
                if(i==0 || j==0) dp[i][j] = 0;
                else if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

                max = Math.max(dp[i][j] , max);
            }
        }

//        for(int i=0 ; i < n ; i++){
//             System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(max);

    }
}
