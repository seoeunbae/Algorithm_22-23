package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_17472 {
    static BufferedReader in;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
    static int[][] nodes;
    static final int INF = 101;
    static List<int[]> list = new ArrayList<>();
    static int[] parents;
    static int cnt;

    public static void main(String[] args) throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] ins = in.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        map = new int[n][m];

        visited = new boolean[n][m];
        for(int i=0 ; i < n ; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j=0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for(int i=0 ; i < n ; i++) {
            for(int j=0 ; j < m ; j++) {
                if( map[i][j] == 1 && !visited[i][j] ) {
                    bfs(i,j,++cnt);
                }
            }
        }

        nodes = new int[cnt+1][cnt+1];
        parents = new int[cnt+1];
        for(int i=1 ; i <= cnt ; i++) {
            for(int j=1 ; j <= cnt ;j++) {
                nodes[i][j] = INF;
                if(i==j) nodes[i][j]=0;
            }
        }

        for(int i=0 ; i < n ; i++) {
            Arrays.fill(visited[i], false);
        }

        for(int i=0 ; i < n ; i++) {
            for(int j=0 ; j < m ; j++) {
                if(map[i][j] >= 1 && !visited[i][j] ) {
                    for(int f=0 ; f < 4 ;f++) {
                        bfsBridge(i,j,f,map[i][j]);
                    }
                }
            }
        }


        for(int i=1 ; i <= cnt ; i ++) {
            for(int j=i+1 ;  j<= cnt ; j ++) {
                if(nodes[i][j] > 0 && nodes[i][j] != INF) {
                    list.add(new int[] {nodes[i][j], i, j});
                }
            }
        }

        for(int i=0 ; i < nodes.length ; i++){
            System.out.println(Arrays.toString(nodes[i]));
        }

        list.sort((a,b)-> { return a[0] - b[0]; });
        //크루스칼하기
        for(int i=1 ; i < parents.length ; i++){
            parents[i] = i;
        }

        int ans = kruskal();


        System.out.println(ans);
    }

    public static void bfs(int i, int j, int item) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i,j});
        visited[i][j] = true;
        map[i][j] = item;
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            for(int f=0 ;f < 4 ; f++) {
                int y = poll[0] + delta[f][0];
                int x = poll[1] + delta[f][1];
                if(inRange(y,x) && !visited[y][x]) {
                    if(map[y][x] == 1) {
                        map[y][x] = item;
                        q.offer(new int[] {y,x});
                        visited[y][x] = true;
                    }
                }
            }
        }
    }

    public static boolean inRange(int y, int x) {
        return y>=0 && x>= 0 && y < n && x < m;
    }

    public static void bfsBridge(int i, int j, int dir, int item) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i,j,0});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0] + delta[dir][0];
            int x = poll[1] + delta[dir][1];
            int dist = poll[2];

            if(inRange(y,x) && !visited[y][x]) {
                if(map[y][x] != 0 && map[y][x] != item && dist >= 2) {
                    nodes[item][map[y][x]] = Math.min(dist, nodes[item][map[y][x]]);
                    nodes[map[y][x]][item] = Math.min(dist, nodes[map[y][x]][item]);
                    break;
                }
                if(map[y][x] == 0) {
                    visited[y][x] = true;
                    q.offer(new int[] {y,x, dist+1});
                }
            }
        }

    }

    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
    public static int find(int x){
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static int kruskal(){
        int ans =0;
        int edge = 0;
        for(int i=0 ; i < list.size() ; i++) {
            int[] ints = list.get(i);
            if(union(ints[1], ints[2])){
                ans += ints[0];
                if(++edge == list.size()-1){
                    break;
                }
            }
        }
        if(ans == 0) return -1;
        if(edge != list.size()-1) return -1;
        return ans;
    }



}

