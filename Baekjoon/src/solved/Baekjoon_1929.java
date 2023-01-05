package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1929 {
    static int[] primeArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        primeArray = new int[N+1];
        for(int i=0; i<=N ; i++){
            if(i <= 1) primeArray[i] = 0;
            primeArray[i] = i;
        }
        for(int i=2 ; i<=Math.sqrt(N) ; i++){
            //이미 지워진 애는 건너뛰기
            if(primeArray[i] == 0) continue;

            for(int j=i*i ; j<=N ; j+=i){
                //배수인 애 지우기
                primeArray[j] = 0;
            }
        }

        for(int i=M; i<= N;i++){
            if(primeArray[i] != 0) System.out.println(primeArray[i]);
        }
    }
}
