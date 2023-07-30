package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int N = chars.length;

        int firstTemp = 0;
        int secondTemp = 0;
        for(int i=0 ; i < N/2 ; i++){
            firstTemp += Integer.valueOf(chars[i]);
            secondTemp += Integer.valueOf(chars[N-i-1]);
        }

        if(firstTemp == secondTemp) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
