package dynamicprogramming;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Downing {
    static int[][] minDp;
    static int[][] maxDp;
    static int[][] initial;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());
        minDp = new int[N][3];
        maxDp = new int[N][3];
        initial = new int[N][3];

        for(int i=0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                initial[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //

        minDp[0][0] = maxDp[0][0] = initial[0][0];

        minDp[0][1] = maxDp[0][1] = initial[0][1];

        minDp[0][2] = maxDp[0][2] = initial[0][2];

        if(N == 1){
            Arrays.sort(initial[0]);
            System.out.println(initial[0][2]+" "+initial[0][0]);
            return;
        }
        for(int i = 1 ; i < N ; i++){
            maxDp[i][0] = Math.max(maxDp[i-1][0] , maxDp[i-1][2] ) + initial[i][0];
            minDp[i][0] = Math.min(minDp[i-1][0] , minDp[i-1][2] ) + initial[i][0];

            maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0] , maxDp[i-1][1]), maxDp[i-1][2]) + initial[i][1];
            minDp[i][1] = Math.min(Math.min(minDp[i-1][0] , minDp[i-1][1]), minDp[i-1][2]) + initial[i][1];

            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2] ) + initial[i][2];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2] ) + initial[i][2];

        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(maxDp[N-1]);
        Arrays.sort(minDp[N-1]);
        sb.append(maxDp[N-1][2]);
        sb.append(" ");
        sb.append(minDp[N-1][0]);

        System.out.println(sb.toString());




    }

}
