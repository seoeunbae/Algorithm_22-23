package implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656 {
    static BufferedReader in;
    static StringTokenizer st;
    static int h;
    static int w;
    static int n;
    static int[][] map;
    static boolean[] visit;
    static boolean[][] visited;
    static int ans=99999999;
    static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());

        for(int t = 1 ; t <= tc ; t++) {
            String[] ins = in.readLine().split(" ");
            n = Integer.parseInt(ins[0]);
            w = Integer.parseInt(ins[1]);
            h = Integer.parseInt(ins[2]);
            map = new int[h][w];
            visit = new boolean[w];
            visited = new boolean[h][w];
            for(int i=0 ; i < h ; i ++) {
                st = new StringTokenizer(in.readLine());
                for(int j=0 ; j < w ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            perm(0,new int[n]);

            System.out.println(ans);
        }
    }

    public static void bfs(int i, int j) {
        //위치 재정리
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int f=0; f < 4 ;f++) {
                for(int ff = 0 ; ff < map[poll[0]][poll[1]] ; ff++) {
                    int y = poll[0] + delta[f][0]*ff;
                    int x = poll[1] + delta[f][1]*ff;
                    if(inRange(y,x) && !visited[y][x]) {
                        if(map[y][x] == 0) continue;
                        if(map[y][x] > 1) {
                            visited[y][x] = true;
                            queue.offer(new int[] {y,x});
                        }
                    }
                }

            }
        }
    }


    public static boolean inRange(int y, int x) {
        return y>=0 && x>=0 && y< h && x< w;
    }

    public static void perm(int level, int[] temp) {

        if(level == n) {
            //1,2,5이런식으로 순서..
            System.out.println(Arrays.toString(temp));
            int[][] last = remainBlock(temp);
            int total = 0;
            for(int i=0 ; i < last.length ; i++){
                for(int j=0 ; j < last[0].length ; j++){
                    if(last[i][j] > 0) total += last[i][j];
                }
            }
            ans = Math.min(total, ans);
            return;
        }

        for(int i=0 ; i < w ; i++) {
            if(!visit[i]) {
                visit[i] = true;
                temp[level] = i;
                perm(level+1, temp);
                visit[i] = false;
            }
        }
    }

    public static int[][] remainBlock(int[] temp) {
        for(int each : temp) {//1
            for(int i=0 ; i < h ; i++) {
                if(map[i][each] != 0) {
                    visited = new boolean[h][w];
                    bfs(i,each);
                    continue;
                }
            }

//			rearrange();압축하기
            for(int i=h-1 ; i >= 0 ; i--) {
                for(int j=w-1 ; j >= 0 ; j--) {
                    if(visited[i][j]) {
                        map[i][j] = 0;
                    }
                }
            }
            int[][] tempMap = new int[h][w];
            int y=0;
            for(int i=0 ; i < h ; i++) {
                int x=0;
                for(int j=0 ; j < w ; j++) {
                    if(map[i][j]!=0) {
                        tempMap[y][x] = map[i][j];
                        x++;
                    }
                }
                y++;
            }
            for(int i=0 ; i < n ;  i++){
                System.out.println(Arrays.toString(tempMap[i]));
            }
            map = tempMap;
        }
        return  map;
    }
}
