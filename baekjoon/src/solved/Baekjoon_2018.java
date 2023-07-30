package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Baekjoon_2018 {
    static int startIdx = 1;
    static int endIdx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.valueOf(br.readLine());
        System.out.println(Func(integer));
    }

    public static Integer Func(Integer number){
        int answer = 0;
        int sum = 1;
        while (startIdx <= number || endIdx <= number) {

            System.out.println(sum);

            if (sum == number) {
                answer += 1;
                System.out.println(" answer : " + answer);
                endIdx++;
            } else if (sum < number) {
                sum -= startIdx;
                startIdx++;

            } else {
                sum += endIdx;
                endIdx++;

            }


        }

        System.out.println(answer);
        return answer;
    }

//    public static int sum(Integer startIdx, Integer endIdx){
//        int result  = 0;
//        if(Objects.equals(startIdx, endIdx)) return startIdx;
//
//        for(int i = startIdx ; i <= endIdx ; i++){
//            result += i;
//        }
//        System.out.println(" : " + result);
//        return result;

//    }
}
