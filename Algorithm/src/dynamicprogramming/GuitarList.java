package dynamicprogramming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GuitarList {
    static int[] V;
    static int[][] dp;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();



        dp = new int[N][2]; //0...n-1
        V = new int[N];//

        arr = new int[M+1];//

        for(int i=0 ; i <= M ; i++){
            arr[i] = -1;
        }

        arr[S] = 0;


        for(int i=0 ; i < N ; i++){
            V[i] = sc.nextInt(); //V=[5,3,7]
        }

        for(int i=1; i<=N ; i++){
            int v = V[i-1];
            List<Integer> list = new ArrayList<>();

            for(int j=0 ; j <= M ; j++){
                if(arr[j] == i - 1){
                    int res1 = j+v;
                    int res2 = j-v;

                    if( 0 <= res1 && res1 <= M) list.add(res1);
                    if( 0 <= res2 && res2 <= M) list.add(res2);
                }
            }

            for(int n : list){
                arr[n] = i;
            }
        }

        int max = -1;


        for(int i=0; i <= M ; i++) {
            if(arr[i] == N){
                max = Math.max(max, i);
            }
        }
        System.out.println(max);




    }


}
