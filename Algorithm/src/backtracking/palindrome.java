package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class palindrome {
    static int T;
    static int K;
    static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();
        int[] dp = new int[N+1];
        Arrays.fill(dp, 2001);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(isPalindrome(j,i,s)) {
                    dp[i+1] = Math.min(dp[i+1],dp[j]+1);
                }else {
                    dp[i+1] = Math.min(dp[i+1],dp[i]+1);
                }
            }
        }
        System.out.println(dp[N]);
    }

    public static boolean isPalindrome( int start, int end, String s){
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


}
