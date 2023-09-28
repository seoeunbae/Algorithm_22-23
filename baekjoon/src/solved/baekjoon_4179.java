package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class baekjoon_4179 {
    static BufferedReader in;
    static Queue<int[]> fq = new ArrayDeque<>();
    static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
    static char[][] map;
    static boolean[][][] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] ins = in.readLine().split(" ");
         n = Integer.parseInt(ins[0]);
         m = Integer.parseInt(ins[1]);
        int[] start = new int[2];
        visited = new boolean[2][n][m];
        map = new char[n][m];
        for(int i=0 ; i < n ; i++){
            String s = in.readLine();
            for(int j=0 ; j < m ; j++){
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'F'){
                    fq.offer(new int[]{i,j});
                    visited[1][i][j] = true;
                }
                if(map[i][j] == 'J'){
                    start = new int[]{i,j};
                }
            }
        }

        int time = bfs(start[0], start[1]);
        if( time == -1){
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(time);
        }
    }

    public static int bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x,0});
        visited[0][y][x] = true;

        while(!q.isEmpty()){
            int fsize = fq.size();
            for(int i=0 ; i < fsize ; i++){
                int[] poll = fq.poll();
                for(int f = 0 ; f < 4 ; f++){
                    int ay = poll[0] + delta[f][0];
                    int ax = poll[1] + delta[f][1];
                    if(inRange(ay,ax) && !visited[1][ay][ax]){
                        if(map[ay][ax] == '#') continue;
                        //.인 경우,J인 경우
                        visited[1][ay][ax] = true;
                        map[ay][ax] = 'F';
                        fq.add(new int[]{ay,ax});
                    }
                }
            }

            int qsize = q.size();
            for(int i=0 ; i < qsize ; i++){
                int[] poll = q.poll();
                int time = poll[2];



                for(int f = 0 ; f < 4 ; f++){
                    int ay = poll[0] + delta[f][0];
                    int ax = poll[1] + delta[f][1];

                    if(ay == n || ax == m || ay == -1 || ax == -1 ){
                        return time+1;
                    }

                    if(inRange(ay,ax) && !visited[0][ay][ax]){
                        if(map[ay][ax] == '#' || map[ay][ax] == 'F') continue;
                        //.인 경우
                        visited[0][ay][ax] = true;
                        q.offer(new int[]{ay, ax, time+1});
                    }
                }
            }

        }
        return -1;
    }

    public static boolean inRange(int y, int x){
        return y >= 0 && x >= 0 && y <= n-1 && x<= m-1;
    }
}
