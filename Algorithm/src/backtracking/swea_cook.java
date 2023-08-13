package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_cook {
    static BufferedReader br;

    static StringTokenizer st;

    static int[][] s;

    static int[] temp;

    static int min;

    static int n;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int z=1 ; z <= t ; z++){
            min = 999999;
            sb.append("#"+z+" ");
            n = Integer.parseInt(br.readLine());
            s = new int[n+1][n+1];
            visit = new boolean[n+1];
            temp = new int[n+1];

            for(int i=1 ; i <= n ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0, 0, temp);
            System.out.println(min);
            sb.append(min+ "\n");
        }
        System.out.println(sb.toString());
    }

    static boolean[] visit;
    public static void comb(int prev , int level ,int[] temp){
        if(level == n/2){
            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();
            for(int i=1 ; i < temp.length ; i++){
                if(temp[i]==1) listA.add(i);
                else listB.add(i);
            }
            int diff = getDiff(listA,listB);
            if(min > diff){ min = getDiff(listA,listB); }
            return;
        }

        for(int i=prev ; i < n ; i++){
            if(!visit[i]){
                visit[i] = true;
                prev = i;
                temp[i] = 1; //1==음식A
                comb(prev, level+1, temp);
                visit[i] = false;
                temp[i] = 0; // 0==음식B
            }
        }
    }

    //int[] temp에서 2개 고르는 가지수
    public static int getDiff(ArrayList<Integer> listA , ArrayList<Integer> listB){
        int sumA = 0;
        for(int i=0 ; i < listA.size() ; i++){
            for(int j=0 ; j < listA.size() ; j++){
                sumA += s[listA.get(i)][listA.get(j)];
            }
        }
        int sumB=0;
        for(int i=0 ; i < listB.size() ; i++){
            for(int j=0 ; j < listB.size() ; j++){
                sumB += s[listB.get(i)][listB.get(j)];
            }
        }
        return Math.abs(sumA-sumB);
    }
}
