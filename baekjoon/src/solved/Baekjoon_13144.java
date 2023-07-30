package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_13144 {
    static List<Integer> list = new ArrayList<>();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i=0 ; i < n ; i++){

            Integer number = Integer.valueOf(stringTokenizer.nextToken());
            System.out.println(number);
            list.add(number);
        }
        Func(list);
    }

    public static void Func(List<Integer> list){
        int L = 0;
        //같은 수가 여러번 등장하지 않는 경우
        for(int R=1; R < list.size() ; R++){
            boolean contains = list.subList(L, R - 1).contains(R);
            if(!contains) count++;
        }

        System.out.println(count);
    }
}
