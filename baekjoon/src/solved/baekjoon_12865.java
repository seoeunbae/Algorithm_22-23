package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_12865 {
    static BufferedReader in;
    static int n;
    static int k;
    static int[] W;
    static int[] V;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
         n = Integer.parseInt(s[0]);
         k = Integer.parseInt(s[1]);
         W = new int[n];
         V = new int[n];
         dp = new int[n][k+1];
         for(int i = 0 ; i < n ; i++ ){
             String[] ins = in.readLine().split(" ");
             int w = Integer.parseInt(ins[0]);
             int v = Integer.parseInt(ins[1]);
             W[i] = w;
             V[i] = v;
         }

         for(int i=0 ; i < n ; i++){
             dp[i][0] = 0;
         }
         for(int i=0 ; i <= k ; i++){
             if(W[0] > i){
                 dp[0][i] = 0;
             }else {
                 dp[0][i] = V[0];
             }

         }

         for(int i=1 ; i < n ;i++){
             for(int j=0 ; j <= k ;j++){
                 //가방 무게 보다 물건 하나의 가중치가 큰 경우
                 if(W[i] > j) {
                     //안담는다.
                     dp[i][j] = dp[i-1][j];
                 }else{
                     //담는경우, 안담는 경우 중 큰 값을 저장
                    dp[i][j] = Math.max(V[i] + dp[i-1][j-W[i]] , dp[i-1][j]);
                 }
             }
         }

         for(int i=0 ; i < dp.length ; i++){
             System.out.println(Arrays.toString(dp[i]));
         }
        System.out.println(dp[n-1][k]);
    }
}
