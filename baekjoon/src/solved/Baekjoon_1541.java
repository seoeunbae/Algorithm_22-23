package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1541 {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split("-");
        int results=0;
        for(int i=0 ; i< splits.length ; i++){
//            results += ;
            int temp = sum(splits[i]);
            if(i == 0 ) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }

    public static Integer sum(String split){
        String[] plusSPlit = split.split("\\+");
        int returnResult = 0;
        for(int i = 0 ; i< plusSPlit.length ; i++){
            int num = Integer.parseInt(plusSPlit[i]);
            returnResult += num;
        }

        return returnResult;
    }
}
