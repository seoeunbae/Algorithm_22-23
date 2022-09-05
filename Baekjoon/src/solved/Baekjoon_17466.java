package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_17466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        System.out.println(s[0] + " " + s[1]);
        Func(Long.valueOf(s[0]), Long.valueOf(s[1]));
    }

    public static void Func(Long N, Long P){
        int answer = 1;

        for(long i=1 ; i <= N ; i++){
            answer *= i;
        }
        System.out.println(answer);
        System.out.println(answer % P);
    }
}
