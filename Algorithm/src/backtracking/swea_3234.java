package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3234 {
    static int t;
    static int n;
    static int[] weights;
    static BufferedReader br;
    static StringTokenizer st;



    static boolean[] visited;
    static boolean[] visitedLevel;
    static int count;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1 ; tc <= t ; tc++){
            n = Integer.parseInt(br.readLine());
            weights = new int[n];
            visitedLevel = new boolean[n];
            visited = new boolean[n];
            st = new StringTokenizer(br.readLine());

            for(int i=0 ; i < n ; i++){
                weights[i] = Integer.parseInt(st.nextToken());
            }

            int[][] scale = new int[2][n];

            bf(0, scale);
            System.out.println(count);
        }

    }

    public static void bf(int level, int LR, int[][] scale){
        if (level == n){
            if (isLeftSmaller(scale, null)){
            	System.out.println(Arrays.toString(scale[0]));
            	System.out.println(Arrays.toString(scale[1]));
            	System.out.println("----------");
                count++;
            }
            return;
        }
         
        for(int i=0 ; i < n ; i++){
            if(!visited[i] && isLeftSmaller(scale, weights[i])){
                visited[i] = true;
                 
                visitedLevel[level] = true;
                scale[0][level] = weights[i]; 
                bf(level+1, 0, scale);
                scale[0][level] = 0;
                scale[1][level] = weights[i]; 
                bf(level+1, 1, scale);
                scale[1][level] = 0; 
                visitedLevel[level] = true;
                visited[i] = false;
            }
            else if(!visited[i]  && !isLeftSmaller(scale, weights[i])) {
            	 visited[i] = true;
            	 scale[1][level] = weights[i]; 
            	 visitedLevel[level] = true;
                bf(level+1, , scale);
                visitedLevel[level] = false;
                visited[i] = false;
            }
        }

    }

    public static boolean isLeftSmaller(int[][] scale, Integer w){
        int left=0;
        int right=0;
        for(int i=0 ; i < n ; i++){
            left += scale[0][i];
            right += scale[1][i];
        }
        if(w==null) return left <= right;
        return left+w <= right;
    }
}
