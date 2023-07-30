package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2178 {
    static int[][] graph;

    static int N, M;
    static int[] ax = new int[]{-1, 0, 1, 0};
    static int[] ay = new int[]{0,-1,0,1};
    static boolean[][] visited;

    static Queue<int[]> queue = new LinkedList<>();

    static int START_INDEX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
         N = Integer.parseInt(split[0]); //렬
         M = Integer.parseInt(split[1]); //행
        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i = 0 ; i<N ; i++){
            String[] split1 = br.readLine().split("");
            for(int j = 0 ; j<M ; j++){
                graph[i][j]= Integer.parseInt(split1[j]);
            }
        }

        bfs(0,0);

    }
//bfs사용해야함
    public static void solution(){

    }

    public static void bfs(int x, int y){
        visited[x][y]=true;
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int eachX = poll[0];
            int eachY = poll[1];
            if(eachX == N-1 && eachY == M-1){
                System.out.println(graph[eachX][eachY]);
                break;
            }
            for(int i=0 ; i<4 ;i++){
                int dx = eachX + ax[i];
                int dy = eachY + ay[i];

                if(dx >= 0 && dy >= 0 && dx < N && dy < M){
                    if(!visited[dx][dy] && graph[dx][dy]==1){
                        queue.add(new int[]{dx, dy});
                        visited[dx][dy] = true;
                        graph[dx][dy]= graph[eachX][eachY]+1;
                    }
                }
            }
        }
    }
}
