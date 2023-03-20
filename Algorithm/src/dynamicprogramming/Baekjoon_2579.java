package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2579 {
    static int[] A;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        A = new int[n+1];

        for(int i = 0 ;  i < n ; i++ ){
            A[i] = Integer.parseInt(br.readLine());

        }
        func();
    }

    public static void func(){
        int[][] Dy = new int[n+1][2];

        // 초기값 구하기
        Dy[1][0] = 0;
        Dy[1][1] = A[1];

        if (n >= 2){
            Dy[2][0] = A[2];
            Dy[2][1] = A[1] + A[2];
        }

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 3; i <= n; i++){
            Dy[i][0] = Math.max(Dy[i - 2][0] + A[i], Dy[i - 2][1] + A[i]);
            Dy[i][1] = Dy[i - 1][0] + A[i];
        }
        System.out.println(Math.max(Dy[n][0], Dy[n][1]));
    }
}
