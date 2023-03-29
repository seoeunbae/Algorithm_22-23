package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {
    static int[][] a;
    //초기화
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        a = new int[N+1][3];
        sum = new int[N+1][3];

        //initialize
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for( int j = 0 ; j < 3 ; j++){
                a[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        //
        for(int i = 1 ; i <= N ; i++){
            sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + a[i][0];
            sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + a[i][1];
            sum[i][2] = Math.min(sum[i-1][1], sum[i-1][0]) + a[i][2];
        }

        System.out.println(Math.min(Math.min(sum[N][0], sum[N][1]), sum[N][2] ) );
    }
}
