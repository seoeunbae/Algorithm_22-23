package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GuitarList {
    static int[] V;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();


//        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N][2]; //0...n-1
        V = new int[N];//


        for(int i=0 ; i < N ; i++){
            V[i] = sc.nextInt(); //V=[5,3,7]
        }

        dp[0][0] = S + V[0];
        dp[0][1] = S - V[0]; //

        if((dp[0][0] < 0 && dp[0][1] < 0) || ( dp[0][1] >M && dp[0][0] > M) ){
            System.out.println(-1);
            return;
        }

        for(int i=1; i < N ; i++){

            int zeroPlus = dp[i-1][0] + V[i];
            int onePlus = dp[i-1][1] + V[i];
            if(dp[i-1][0] + V[i] > M){
                zeroPlus = -1;
            }
            if(dp[i-1][1] + V[i] > M){
                onePlus = -1;
            }
            if(zeroPlus ==-1 && onePlus== -1){
                System.out.println(-1);
                return;
            }
            dp[i][0] = Math.max(zeroPlus , onePlus);

            if(dp[i-1][0] - V[i] < 0 && dp[i-1][1] - V[i] < 0){
                System.out.println(-1);
                return;
            }
            dp[i][1] = Math.max(dp[i-1][0] - V[i] , dp[i-1][1] - V[i]);

        }


        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));






    }


}
