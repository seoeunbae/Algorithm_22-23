package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_13144_twopointer {
        static int[] count = new int[1000000 + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] ints = new int[N+1];
        for (int i = 1; i <= N; i++) {
            ints[i] = Integer.parseInt(split[i-1]);
        }
        int answer = 0;
//        int R = 0;
//        int R =0;
        for (int L = 1, R = 0; L <= N; L++) { //selected array

            if(count[ints[L-1]] > 0) count[ints[L-1]]--;

            while (R+1 <= N && count[ints[R + 1]] <= 0) {
                count[ints[++R]] ++;
            }

            answer += R - L +1 ;

//            count[ints[L]]--;
        }
        System.out.println(answer);
    }





}
