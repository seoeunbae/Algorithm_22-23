package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14500 {
    static BufferedReader in;
    static StringTokenizer st;
    static int n;
    static int m;

    static int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};

    static int[][] board;

    static boolean[][] inVisited;
    static int max;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]); //y
        m = Integer.parseInt(s[1]); //x
        board = new int[n][m];
        inVisited = new boolean[n][m];

        for(int i=0 ; i < n ; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0 ; j < m ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i < n ; i++){
            for(int j= 0; j < m ; j++){
                    inVisited[i][j] = true;
                    dfs(i, j, 1, board[i][j]);
                    inVisited[i][j] = false;
            }
        }


        System.out.println(max);
    }

    public static void dfs(int i, int j,  int cnt, int sum){
        if(cnt==4){
            max = Math.max(sum, max);
            return;
        }

        for(int f=0 ; f < 4 ; f++){
            int y = i + delta[f][0];
            int x = j + delta[f][1];
            if( y >= 0 && x >= 0 && y < n && x < m){
                if(!inVisited[y][x]) {
                    // 범위안에 있을때는...
                    inVisited[y][x] = true;
                    if(cnt==2){
                        inVisited[y][x] = true;
                        dfs(i, j, cnt+1,sum + board[y][x]);
                        inVisited[y][x] = false;
                    }
                    inVisited[y][x] = true;
                     dfs(y, x, cnt + 1, sum + board[y][x]);
                    inVisited[y][x] = false;
                }
            }
        }
    }


}
