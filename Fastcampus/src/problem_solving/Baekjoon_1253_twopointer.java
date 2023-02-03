package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1253_twopointer {
    static int sum = 0;
    static int L=0, R;
    static int answer=0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] ints = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        R = N - 1;
        Arrays.sort(ints);

        pro(ints);
    }

    public static void pro(int[] ints){
        sum  = ints[R] + ints[L];
        for(int i = 0 ; i < N ; i++) {
            while (L < R) {
                int target = ints[i];
                if(L==i) L++;
                else if (R == i) R--;

                if (sum == target) {
                    answer++;
                } else {
                    if (sum > target) {
                        L++;
                        sum -= ints[L];
                    } else {
                        if( R+1 >= N) break;
                        R++;
                        sum += ints[R];
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void input(){

    }
}
