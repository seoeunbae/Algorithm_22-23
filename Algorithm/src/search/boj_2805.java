package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805 {
    static BufferedReader br;
    static StringTokenizer st;

    static long[] array;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Integer.parseInt(s[1]);

        st = new StringTokenizer(br.readLine());
        array = new long[n];
        long max = 0;
        for(int i=0 ; i < n ; i++){
            array[i] = Long.parseLong(st.nextToken());
            if (max < array[i]) max = array[i];
        }

        Arrays.sort(array);

        long low = 0;
        long high =  2_000_000_000;
        while(low <= high){
            long mid = (low + high) / 2;
            //절단기의 높이에 해당하는 가져가는 나무 길이
            long len = calLen(mid);
//            System.out.println(len);
            if(len >= m){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
//        System.out.println(low);
        System.out.println(high);
    }

    public static long calLen(long x){
        long sum = 0;
        for(int i=0 ; i < array.length ; i++){
            long each = array[i] - x;
            if (each < 0 ) continue;
            sum += each;
        }
        return sum;
    }
}
