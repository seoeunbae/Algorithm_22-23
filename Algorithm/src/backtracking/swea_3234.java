package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3234 {
    static int t;
    static int n;
    static int[] weights;
    static BufferedReader br;
    static StringTokenizer st;



    static boolean[] visited;
    static int count;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1 ; tc <= t ; tc++){
            n = Integer.parseInt(br.readLine());
            weights = new int[n];

            visited = new boolean[n];
            st = new StringTokenizer(br.readLine());

            for(int i=0 ; i < n ; i++){
                weights[i] = Integer.parseInt(st.nextToken());
            }

            int[][] scale = new int[2][n];

            for(int i=0 ; i < 2 ; i++){
                bf(0, i, scale);
            }
            System.out.println(count);
        }

    }

    public static void bf(int level,int LR, int[][] scale){
        if (level == n){
            if (isLeftSmaller(scale, null)){
                count++;
            }
            return;
        }

        for(int i=0 ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true;
                scale[LR][level] = weights[i];
                if(!isLeftSmaller(scale, weights[i])) continue;
                bf(level+1, 0, scale); // scale를 초기화 해줘야함
                bf(level+1, 1, scale);

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
