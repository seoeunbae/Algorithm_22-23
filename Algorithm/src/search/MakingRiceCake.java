package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MakingRiceCake {
    static long[] array;
    static int M;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        array = new long[N];

        M = scanner.nextInt();

        for(int i=0 ; i < N ; i++){
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);



    }

    public static void binarySearch(int start, int end, int max){
        if(start > end){
            return;
        }

        int mid = start + ((end - start) / 2);
        if(mid > max ) max = mid;
        int total = calculate(mid);
        if(  total == M ) {
            System.out.println(mid);
            return;
        } else if (total >= M) {
            binarySearch(mid+1, end, max);

        } else {
            binarySearch(start, mid-1 ,max);
        }

    }

    public static Integer calculate(int mid){
        int result = 0;

        for(long each : array){
            if( each - mid > 0){
                result += (each - mid);
            }
        }
        return result;
    }


}
