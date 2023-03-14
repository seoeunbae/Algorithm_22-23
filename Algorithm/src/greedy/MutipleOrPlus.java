package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MutipleOrPlus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chars = br.readLine();

        System.out.println(solution(chars));
    }

    public static long solution(String chars){
        long result = chars.charAt(0) - '0';
        //아스키코드 값이 나오므로 48인'0'을 뺴줘야 정수값이 나온다.
        System.out.println(result);
        for(int i=1 ; i < chars.length() ; i++){
            int num = chars.charAt(i) - '0';
            if(num <= 1 || result <= 1){
                result += num;
            } else {
                result *= num;
            }

        }
        return result;
    }
}
