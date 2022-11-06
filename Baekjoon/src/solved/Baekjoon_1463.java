package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1463 {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());

        dp = new Integer[num+1];
        System.out.println(solve(num));


    }

    public static Integer Func(int num){
        dp[1] = 0;

        for(int i=2; i<= num ; i++){
            dp[i]=dp[i-1]+1;

            if(i%2 == 0 && dp[i] > dp[i/2]+1) {
                dp[i]=dp[i/2]+1;
            }

            if(i%3 == 0 && dp[i] > dp[i/3]+1) {
                dp[i]=dp[i/3]+1;
            }
        }

        return dp[num];

    }

    public static int solve(int X) {
        if (X == 1)
            return 0;
        if (dp[X] != null)
            return dp[X];
        dp[X] = solve(X-1);
        if (X % 2 == 0)
            dp[X] = Math.min(dp[X], solve(X/2));
        else if (X % 3 == 0)
            dp[X] = Math.min(dp[X], solve(X/3));
        else dp[X]++;
        return dp[X];
    }
}

