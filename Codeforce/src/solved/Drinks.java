package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Drinks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double result =0;

        for(int i=0; i<n ; i++){
            int pi = Integer.parseInt(st.nextToken());
            result += pi;
        }

        System.out.println(result/n);
    }
}
