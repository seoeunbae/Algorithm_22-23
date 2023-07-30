package backtracking;

import dynamicprogramming.Sticker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15666 {
    static StringTokenizer st;
    static BufferedReader br;
    static int N;
    static int M;
    static int[] array;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[N];

        for(int i=0 ; i< N ; i++){
           array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int[] temp = new int[M];
        perm(0,0, temp);

    }

    public static void perm(int prevIdx, int level, int[] temp){
        if(level == M){//4==4
            for(int element : temp){
                System.out.print(element + " ");
            }
            System.out.println();
            return;
        }
        int prev = 0;
        for(int i = prevIdx ; i < N ; i++){ // prev=2,prevIdx=2
            if (prev != array[i]) { //0!=1 | 0!=1 | 2 !=
                temp[level] = array[i];//temp[0] = 1 | temp[1] = 1
                prevIdx = i; // prevIdx=0 | prevIdx = 1
                prev = temp[level];//prev=1 | prev = 1
                perm(i,level + 1, temp);//(0,1,[1,0,0,0])|(2,4,[1,1,2,2])|
            }
        }
    }
}
