package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_3055 {
    static BufferedReader in;
    static StringTokenizer st;
    static int n;
    static int m;
    static char[][] map;
    static boolean[][][] visited;
    static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
    static int[] target;

    static Queue<int[]> wq = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] ins = in.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        map = new char[n][m];
        visited = new boolean[2][n][m];

        int[] start = new int[3];
        int[] wstart = new int[3];
        target = new int[2];

        for(int i=0 ; i < n ; i++) {
            String s = in.readLine();
            for(int j=0 ; j < m ; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') {
                    start = new int[] {i,j,0};
                }
                if(map[i][j]=='*') {
                    wstart = new int[] {i,j,0};
                    wq.add(wstart);
                }
                if(map[i][j]== 'D') {
                    target = new int[] {i,j};

                }
            }
        }

        int ans = bfs(start[0], start[1],wstart[0], wstart[1], 0,0);
        if(ans==-1) {
            System.out.println("KAKTUS");
        }else {
            System.out.println(ans);
        }
    }

    public static int bfs(int y , int x , int wy, int wx, int cnt, int wcnt) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {y,x,cnt});
        visited[0][y][x] = true;
        visited[1][wy][wx] = true;

        while(!q.isEmpty()) {
            //물 먼저
            int wqsize = wq.size();
            for(int w = 0 ; w < wqsize ; w++){
                int[] wpoll = wq.poll();
                int worder = wpoll[2];
                for(int f=0 ; f < 4; f++){
                    int way = wpoll[0] + delta[f][0];
                    int wax = wpoll[1] + delta[f][1];

                    if(inRange(way,wax) && !visited[1][way][wax]) {
                        if(map[way][wax] == '.' ) {
                            visited[1][way][wax] = true;
                            map[way][wax] = '*';
                            wq.offer(new int[] {way, wax, worder+1});
                        }
                    }
                }
            }
            int qsize = q.size();
            for(int m = 0 ; m < qsize ; m++){
                int[] poll = q.poll();
                int order = poll[2];
                if(poll[0] == target[0] && poll[1] == target[1] ) {
                    return order;
                }

                for(int f=0 ; f < 4 ; f++) {
                    int ay = poll[0] + delta[f][0];
                    int ax = poll[1] + delta[f][1];
                    if(inRange(ay,ax) && !visited[0][ay][ax]) {
                        //.이면 이동
                        if(map[ay][ax] == '.' || map[ay][ax] == 'D') {
                            visited[0][ay][ax] = true;
                            q.offer(new int[] {ay,ax,order+1});
                        }
                    }
                }


            }
        }
        return -1;
    }

    public static boolean inRange(int y ,int x) {
        return y >=0 && x>= 0  && y <n && x< m;
    }
}