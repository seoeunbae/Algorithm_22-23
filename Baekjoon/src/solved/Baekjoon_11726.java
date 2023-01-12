package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11726 {
    static int[] D = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());

        for(int i=1 ; i<= num ; i++){
            solution(i);
        }

        System.out.println(D[num]);
    }

    public static void solution(int num){
        if(num == 1){
            D[num] = 1;
        } else if( num == 2){
            D[num] = 2;
        } else {
            D[num] = (D[num - 1] + D[num - 2]) %10007;
        }
    }
}
