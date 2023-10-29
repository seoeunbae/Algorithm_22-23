package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14921 {
    static BufferedReader in;
    static StringTokenizer st;
    static int n;

    static int[] array;

    static int min=99999999;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        for(int i=0 ; i < n ; i++){
            int i1 = array[i] * -1;
            int idx = upperBound(i1);


            if(Math.abs(min) > Math.abs(array[i] + array[idx])){
                min = array[i] + array[idx];
            }
        }

        System.out.println(min);
    }

    public static int upperBound(int val){
        int low = 0;
        int hi = n-1;

        while(low < hi){
            int mid = (low+hi)/2;

            if(val < array[mid]){
                hi = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
