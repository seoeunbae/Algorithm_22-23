package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTile {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        d = new int[1001];
        System.out.println(dp(N));
    }
    public static Integer dp(int N){
        if(N == 0) return 1;
        if(N == 1) return 0;
        if(N == 2) return 3;
        if(d[N] != 0 ) return d[N];
        int result = 3 * dp(N-2);
        for(int i=3; i<= N ; i++){
            if(i % 2 == 0){
                result += 2 * dp(N - i);
            }
        }
        return d[N] = result;
    }
}
