package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Drink {
    static int[][] graph;
    static int count = 0;
    static boolean[][] visited;
    static int[] dx= new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int N;
    static int M;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0 ; i<N ; i++){
            String[] line = br.readLine().split("");
            for ( int j=0 ; j < line.length ; j++){
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int i=0 ; i < N ; i++){
            for(int j =0 ; j < M ; j++){
                if(dfs(i,j)){
                    count+=1;
                }
            }
        }
        System.out.println(count);

    }

    public static boolean dfs(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= M) {
            return false;
        }
         if(graph[x][y] == 0){
            graph[x][y] = 1;
            for(int i = 0 ; i < dx.length ; i++){
                dfs(x-1, y);
                dfs(x, y-1);
                dfs(x+1 , y);
                dfs(x, y+1);

                return true;
            }
        }
        return false;
    }
}
