package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_11050_1 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        memo = new int[N+1]; //0~N
        for(int i=0 ; i< memo.length ; i++){ // 0~N
            memo[i] = factorial(i);
        }
        System.out.println(solution(N,K));

    }

    public static Integer solution(int N , int K){
        if(K == 0 || N==K ) return 1; //이항계수 공식에 의하면, 1이다.
        else return memo[N]/(memo[K]*memo[N-K]);
    }

    public static Integer factorial(int N){
        if(N < 3) return N;
        else return memo[N-1] * N;
    }
}
