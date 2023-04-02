package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntWarrior {
    static int[] array;
    static int[] dp;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[N];
        dp = new int[N];
        for(int i = 0 ; i< N ; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = array[0];
        dp[1] = Math.max(array[0] , array[1]);
        for(int i=2 ; i < N ; i++){
            dp[i] = Math.max(dp[i-2]+ array[i] , dp[i-1]);
        }

        System.out.println(dp[N-1]);


    }
}
