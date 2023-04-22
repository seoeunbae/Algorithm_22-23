package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_18185 {
    static int cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N =Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int[] A = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        while(Arrays.stream(A).sum() >= 0){
            if(){

            }
        }
    }
}
