package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1767 {
    static int T;
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static int n;
    static boolean[][] visited;
    static Stack<int[]> stack = new Stack<>();

    static final int ROAD = 100;

    static int[][] deltas = {{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1){
                    if (i==0 || j==0) continue;
                    stack.add(new int[]{i,j,-1});
                }
            }
        }

        search();


    }

    public static void search(){
        while(!stack.isEmpty()){
            int[] poll = stack.pop(); //1,2
            if (poll[3] > -1){
                int y = poll[0]+deltas[poll[3]][0];
                int x = poll[1]+deltas[poll[3]][1];

                if ( y > 0 && y < n && x > 0 && x < n && !visited[y][x] && map[y][x] == 0){
                    stack.add(new int[]{y,x,poll[3]});
                    visited[y][x] = true;
                    map[y][x] = ROAD;
                }
            }
            else {
                for (int i = 0; i < 4; i++) {
                    int y = poll[0] + deltas[i][0];
                    int x = poll[1] + deltas[i][1];

                    if (y > 0 && y < n && x > 0 && x < n && !visited[y][x] && map[y][x] == 0) {
                        stack.add(new int[]{y, x, i});
                        visited[y][x] = true;
                        map[y][x] = ROAD;
                    }
                }
            }
        }
    }




}
