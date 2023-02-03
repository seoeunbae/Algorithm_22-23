package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon_2470_Twopointer {
    static int bestSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer N = Integer.parseInt(br.readLine());
        String[] splits = br.readLine().split(" ");

        int[] ints = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(ints);
        int L= 0, R=N-1;
        int v1=0, v2 = 0;

        while(L < R){
            int sum = ints[L]+ints[R];
            //현재 인덱스 합을 통한 정답 갱신
            int i=0;
            if(Math.abs(sum) < bestSum) {
                bestSum = Math.abs(sum);
                v1 = ints[L];
                v2 = ints[R];
            }
            //인덱스 이동에 대한 판단
            if( sum > 0){
                R--;
            }  else  L++;
        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());
    }


}
