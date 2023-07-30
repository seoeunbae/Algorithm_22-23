package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        for(int i=0 ; i < T ; i++){
            Integer N = Integer.parseInt(br.readLine());
            String[] chars00 = br.readLine().split(" ");
            String[] chars01 = br.readLine().split(" ");
            int[][] array = new int[2][N+1];
            int[][] dp = new int[2][N+1];

            for( int j=0 ; j < N ; j++){
                array[0][j] = Integer.parseInt(chars00[j]);
                array[1][j] = Integer.parseInt(chars01[j]);
            }

            dp[0][0] = array[0][0];
            dp[1][0] = array[1][0];
            dp[0][1] = dp[1][0] + array[0][1];
            dp[1][1] = dp[0][0] + array[1][1];
            for(int j = 2 ; j < N ; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + array[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + array[1][j];
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }
    }


}
