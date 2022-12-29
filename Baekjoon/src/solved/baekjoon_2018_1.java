package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2018_1 {
    static int[] array;
    static int startidx = 0;
    static int endidx = 0;
    static int count = 1;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());
        array = new int[num];
        for(int i=0 ; i < num ; i++){
            array[i] = i+1;
        }

        solution(array);
    }

    public static void solution(int[] array){
        while(endidx < array.length){
            if(sum == array.length) {
                count++;
                endidx++;
                sum += array[endidx-1];

            }
            else if (sum > array.length){
                sum-=array[startidx];
                startidx++;
            }
            else if(sum < array.length){
                endidx++;
                sum += array[endidx-1];
            }
        }

        System.out.println(count);
    }
}
