package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SwapElementArray {
    static int K;
    static int N;
    static int[] string01;
    static int[] string02;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
         N = Integer.parseInt(s[0]);
         K = Integer.parseInt(s[1]);

        StringTokenizer string1 = new StringTokenizer(br.readLine());
        StringTokenizer string2 = new StringTokenizer(br.readLine());
        string01 = new int[N]; //0...N-1
        string02 = new int[N];

        for(int i=0 ; i < N ; i++){
            string01[i] = Integer.parseInt(string1.nextToken());
            string02[i] = Integer.parseInt(string2.nextToken());
        }

        func();
        System.out.println(Arrays.stream(string01).sum());
    }

    //swap
    public static void func(){
        Arrays.sort(string01); // 오름차순 0,1,2...,K
        Arrays.sort(string02);

        for(int i = 0 ; i < K ; i++){
            string01[i] = string02[N-1-i];
        }
    }
}
