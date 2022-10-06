package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2178 {
    static int[] dx = {1, 0, -1,0};
    static int[] dy = {0,1, 0, -1};
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visited = new boolean[N+1][M+1];
        map = new int[N+1][M+1];
        for(int i=1 ; i<=N ; i++){
            String[] st = br.readLine().split("");
            for(int j=1 ; j<=M ; j++){
                map[i][j] = Integer.parseInt(st[j-1]);
            }

        }
        System.out.println(bfs(1,1));
    }

    public static Integer bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        visited[x][y] = true;



        while(!queue.isEmpty()){
            int[] poll = queue.remove();


            for(int i=0 ; i<4 ; i++){
                int ax = poll[0] + dx[i];
                int ay = poll[1] + dy[i];
                if(ax > 0 && ay> 0 && ax <= N && ay <= M) {
                    if (!visited[ax][ay] && map[ax][ay] != 0) {
                        queue.add(new int[]{ax, ay});
                        map[ax][ay] = map[poll[0]][poll[1]] + 1;
                        visited[ax][ay] = true;
                    }
                }
            }




            }
            return map[N][M];
        }
    }

