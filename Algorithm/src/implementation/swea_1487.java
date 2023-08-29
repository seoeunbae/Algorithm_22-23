package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_1487 {
    static BufferedReader br;
    static StringTokenizer st;
    static int t;
    static int n;
    static int s;
    static int[] set;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        s = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        set = new int[n];

        for(int i=0 ; i < n ; i++){
           set[i] = Integer.parseInt(s2[i]);
        }

        visited = new boolean[n];
        subset2(0, 0, new ArrayList<>(),n);
    }

    public static void subset( int level, int sum){

        if(level == n){
            if (sum == s){
                count++;
            }
        }

        visited[level] = true;
        subset(level+1,sum+set[level]);
        visited[level] = false;
        subset(level+1, sum);
    }

    public static void subset2( int level, int sum, ArrayList<Integer> temp, int setCnt){

        System.out.println();
        if(level == setCnt){
            for(int i=0 ; i < temp.size() ; i++){
                System.out.print(temp.get(i)+ " ");
            }
            return;
        }
        temp.add(set[level]);
        visited[level] = true;
        subset2(level+1,sum+set[level],temp,setCnt);
        temp.remove(temp.size()-1);
        visited[level] = false;
        subset2(level+1, sum, temp, setCnt);
    }
}
