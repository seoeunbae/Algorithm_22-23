package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Baekjoon_7576 {
    static int M;
    static int N;
    static int[][] map;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean[][] visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        map = new int[M][N];
        visited =new boolean[M][N];
        for(int i=0 ;i <N ; i++){
            String[] strings = br.readLine().split(" ");

            for(int j=0 ; j < M; j++){
                map[j][i] = Integer.parseInt(strings[j]);
            }
        }

        System.out.println(bfs(0,0));
    }

    public static Integer bfs(int x, int y){
        Stack<int[]> stack =new Stack<>();
        stack.add(new int[]{x,y});
        visited[x][y] =true;
        System.out.println("bfs : ");
        while(!stack.isEmpty()){
            int[] pop = stack.pop();
            for(int i=0 ; i < 4 ; i++){
                int ax = dx[i] + pop[0];
                int ay = dy[i] + pop[1];
                if(ax>=0 && ay>=0 && ax<M && ay<N ){
                    if(!visited[ax][ay] && map[ax][ay]!=-1){

                        map[ax][ay]=map[pop[0]][pop[1]]+1;

                        stack.add(new int[]{ax,ay});
                        visited[ax][ay] = true;

                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i=0 ;i<N; i++){
            for(int j=0 ; j<M ;j++){
                if(map[j][i] == 0) return -1;

                result = Math.max(result, map[j][i]);
            }
        }

        if(result ==1) return 0;
        else return result-1;
    }


}
