package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1806 {
    static int R = 0;
    static int answer ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split =  br.readLine().split(" ");

        Integer N = Integer.parseInt(split[0]);
        Integer S = Integer.parseInt(split[1]);

        answer = N+2;

        String[] split1 = br.readLine().split(" ");
        int[] Ns = Arrays.stream(split1).mapToInt(Integer::parseInt).toArray();
        int sum = Ns[0];

        for(int L = 0  ; L < N ; L++){


            while( R + 1 < N && sum < S){
                R++;
                sum += Ns[R];
            }
            if(sum >= S){
//                sum -= Ns[L - 1];
                sum -= Ns[L];
//                System.out.println("ekq");
                answer = Math.min(answer, R- L + 1);
            }
        }
        if(answer == N + 2){
//            System.out.println("vdvd");
            answer = 0;
        }

        System.out.println(answer);
        }

}