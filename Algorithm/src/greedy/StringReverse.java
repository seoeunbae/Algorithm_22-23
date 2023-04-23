package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();


        int oneCnt = 0;
        int zeroCnt = 0;
        int prev = string.charAt(0) - '0';

        if(prev==0) oneCnt++;
        else zeroCnt++;

        for(int i=0 ; i < string.length()-1 ; i++){
            if(string.charAt(i) != string.charAt(i+1)){ //연속이 아니라면
                if(string.charAt(i+1) == '0') oneCnt++;
                else zeroCnt++;
            }
        }
        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
