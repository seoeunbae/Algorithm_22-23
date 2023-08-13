package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon_12865 {
    static BufferedReader br;
    static int k;
    static int n;
    static boolean[] visited;
    static int max =0;
    static ArrayList<int[]> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        visited = new boolean[n];

        for(int i=0 ; i < n ; i++){
            String[] inputs = br.readLine().split(" ");
            int[] item = new int[]{ Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]) };
            items.add(item);

        }
        powerset(0,0,0 ,0);
        System.out.println(max);

    }

    public static void powerset(int prev, int level, int weight, int value){
        if(weight == k ||  level == n) {
            max = Math.max(max, value);
            return;
        }


        for(int i=prev ; i < n ; i++){
            if (!visited[i]){
                visited[i] = true;
                prev = i;
                int w = items.get(i)[0];
                int v = items.get(i)[1];
                if (weight + w <= k){
                    powerset(prev+1, level+1, weight+w, value+v);
                }
                visited[i] = false;
            }
        }
    }
}
