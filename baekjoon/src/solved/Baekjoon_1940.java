package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Baekjoon_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] splits = br.readLine().split(" ");
        int[] numbers = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(numbers);
        solution(numbers, M, N);
    }

    public static void solution(int[] numbers, int M , int N){
        int start = 0;
        int end = N-1;
        int count = 0;
        while (start < end) {
            if(numbers[start]+numbers[end] == M){
                count++;
                start++;
                end--;
            }
            else if (numbers[start]+numbers[end] < M ){
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(count);

    }

    //Arrays.sort() == nlogn, n^2
    //Collections.sort() == nlogn
    //stream.sorted() ==

    //투포인터! 활용 근데 이제 연속이 아니라, 양끝에서 가까워지는 형태이다!!

}
