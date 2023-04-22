package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int money = 1000-N;
        int count =0;
        count += money/500;
        money %= 500;
        count += money/100;
        money %= 100;
        count += money/50;
        money %= 50;
        count += money/10;
        money %= 10;
        count += money/5;
        money %= 5;
        count += money;

        System.out.println(count);

    }
}
