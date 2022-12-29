package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_11659_1 {
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        String[] numbers = br.readLine().split(" ");
        int[] nums = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        s = new int[N+1];
        for(int i=1 ; i<= nums.length ; i++){
            if(i==1) s[i] = nums[i-1];
            else s[i] = s[i-1]+nums[i-1];
        }

        for(int i = 1 ; i<= M ; i++){
            String[] range = br.readLine().split(" ");
            int I = Integer.parseInt(range[0]);
            int J = Integer.parseInt(range[1]);
            int answer = s[J] - s[I-1];
            System.out.println(answer);
        }
    }


}
