package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS_Baekjoon_2667 {
    static int N;
    static int group_count = 0;
    static ArrayList<Integer> group = new ArrayList<>();
//    static int[] houseCount = new int[25 * 25];

    static int[][] map; // 0부터 시작
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            x= x;
            y= y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        print();

    }

    public static void pro(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    group_count = 0;
                    dfs(i,j);
                    group.add(group_count);
                }
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            String[] split = br.readLine().split("");
            for(int j = 0 ;  j < split.length ; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    public static void dfs(int x, int y){
        group_count++;

        visited[x][y] = true;


        for(int k=0 ; k< 4 ; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(inRange(nx,ny)){
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        dfs(nx,ny);
                    }
                }

            }
        }


    public static void print(){
        Collections.sort(group);
        System.out.println(group.size());

        for(int i = 0 ; i < group.size() ; i++){
             System.out.println(group.get(i));
        }
    }

    private static boolean inRange(int bx, int by){
        return bx >= 0 && bx < N && by >= 0 && by < N ;
    }

}
