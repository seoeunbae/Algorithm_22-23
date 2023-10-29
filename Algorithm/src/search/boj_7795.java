package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7795 {
    static BufferedReader in;
    static StringTokenizer st;
    static int t;

    static int[] sortedM;
    static int[] sortedN;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(in.readLine());

        for(int i=0; i < t ; i++){
            String[] ins = in.readLine().split(" ");
            int n = Integer.parseInt(ins[0]);
            int m = Integer.parseInt(ins[1]);

            String[] ns = in.readLine().split(" ");
            sortedN = Arrays.stream(ns).mapToInt(Integer::parseInt).sorted().toArray();
            String[] ms = in.readLine().split(" ");
            sortedM = Arrays.stream(ms).mapToInt(Integer::parseInt).sorted().toArray();
            int sum = 0;
            for(int ele : sortedM){
                int idx = upperbound(ele);
                sum += n-idx;
            }
            System.out.println(sum);
        }

    }

    public static int upperbound(int ele){
        int low = 0;
        int hi = sortedN.length;

        while(low < hi){
            int mid = (low+hi) / 2;
            if(ele < sortedN[mid]){
                hi = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
