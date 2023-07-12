package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Baekjoon_1149 {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;

    static int[][] cost;
//    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        cost = new int[N][3];

        //cost 초기화
        for(int i=0 ; i<N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        //메모이제이션, top-down 방식
        for(int i=1; i< N ; i++){
            cost[i][RED] += Math.min(cost[i-1][GREEN], cost[i-1][BLUE]);
            cost[i][GREEN] += Math.min(cost[i-1][RED], cost[i-1][BLUE]);
            cost[i][BLUE] += Math.min(cost[i-1][GREEN], cost[i-1][RED]);
        }


        System.out.println(Math.min(Math.min(cost[N-1][RED], cost[N-1][GREEN]), cost[N-1][BLUE]));
    }

}