package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.OptionalInt;

public class Baekjoon_3020 {
    static int[] S;
    static int[] J;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int H = Integer.parseInt(s[1]);
        S = new int[H+1];
        J = new int[H+1];

        for(int i=1 ; i <= N ; i++){
            Integer m =Integer.parseInt(br.readLine());
            if(i%2==1){
                S[m]++;
            } else J[m]++;
        }





        for(int i=H ; i >= 1 ; i--){
            S[i-1] = S[i] + S[i-1];
            J[i-1] = J[i] + J[i-1];

        }
        int count=0;

        int min = 200001;
        for(int i=1 ; i<= H ; i++){
            int temp = S[i]+ J[H+1-i];
            if(temp < min) {
                min = temp;
                count=1;
            }
            else if(temp == min){
                count++;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(count);
        System.out.println(sb.toString());
    }

}
