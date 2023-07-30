package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.valueOf(br.readLine());
        String[] numbers = br.readLine().split("");

        System.out.println(solution(numbers));
    }

    public static Integer solution(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }
}
