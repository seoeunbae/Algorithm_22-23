package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Until01 {
    static Integer K;
    static Integer count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }

    public static Integer solution(int N){
        while(N > 1){
            count++;
            if(N % K == 0) N /= K;
            else N -= 1;


        }
        return count;
    }
}
