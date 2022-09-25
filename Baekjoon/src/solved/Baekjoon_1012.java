package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1012 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};

    static int[][] map;
    static boolean[][] visited;

    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0;j<K;j++){
                String s = br.readLine();
                int X = Integer.parseInt(s.split(" ")[0]);
                int Y = Integer.parseInt(s.split(" ")[1]);
                map[X][Y] = 1;
            }

            int count = 0;

            for(int z=0;z<M;z++){
                for(int k=0;k<N;k++){
                    if(map[z][k] == 1 && !visited[z][k]){
                        count++;
                        dfs(z, k);
                    }
                }
            }

            System.out.println(count);
        }
    }
    public static void dfs(int x, int y){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x,y});
        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            visited[pop[0]][pop[1]] = true;

            for(int i=0 ; i<4 ;i++){
                int ax = pop[0] + dx[i];
                int ay = pop[1] + dy[i];

                if(ax < 0 || ay< 0 || ax>= M || ay >= N) continue;

                if(visited[ax][ay]|| map[ax][ay]==0){
                    continue;
                }

                dfs(ax, ay);
            }
        }
    }

}
