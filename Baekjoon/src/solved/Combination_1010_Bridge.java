package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combination_1010_Bridge {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.valueOf(br.readLine());

        for(int i=0 ; i < T ;i++){
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            dp = new int[M+1][N+1];
            System.out.println(dpFunc(M,N));
        }
    }

    public static Integer dpFunc(int n, int k){ //n개 중에 k개
        if(dp[n][k] > 0){
            return dp[n][k];
        }

        if(n==k || k==0){
            return dp[n][k]=1;
        }

        return dp[n][k]= dpFunc(n-1,k-1)+dpFunc(n-1,k);
    }
}
