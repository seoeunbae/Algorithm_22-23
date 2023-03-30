package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine {
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        dp = new int[N+1];
        for(int i=1 ; i < N  ; i++){
           array[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = array[1];
        if(N>1){
            dp[2] = array[1]+array[2];
        }

        for(int i = 3; i <= N ; i++){
            dp[i] = Math.max(dp[i-3]+array[i-1]+array[i] , dp[i-2]+array[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        System.out.println(dp[N]);
    }

}
