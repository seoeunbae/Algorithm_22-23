package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoPointer_Baekjoon_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int left= 0;
        int right = 0;

        String[] s1 = br.readLine().split(" ");
        int[] ints = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(ints);
        int count = 0;
        int sum =0;
        while(true){

            if(right == N) break;
            else if( sum >= M){
                sum -= ints[left++];
            } else{
                sum += ints[right++];
            }

            if(sum == M ){
                count++;
            }

        }

        System.out.println(count);
    }
}
