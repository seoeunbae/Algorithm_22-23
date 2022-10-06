package unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_7576 {
    static int M;
    static int N;
    static int[][] map;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean[][] visited;
    static Queue<int[]> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0 ;i < N ; i++){
            String[] strings = br.readLine().split(" ");

            for(int j=0 ; j < M; j++){
                map[i][j] = Integer.parseInt(strings[j]);
                if(map[i][j]==1){
                    stack.add(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static Integer bfs(){

        while(!stack.isEmpty()){
            int[] pop = stack.poll();
            for(int i=0 ; i < 4 ; i++){
                int ax = dx[i] + pop[0];
                int ay = dy[i] + pop[1];
                if(ax >= 0 && ay >= 0 && ax < N && ay < M ){
                    if( map[ax][ay]==0){

                        map[ax][ay]=map[pop[0]][pop[1]]+1;

                        stack.add(new int[]{ax,ay});

                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i=0 ;i<N; i++){
            for(int j=0 ; j<M ;j++){
                if(map[i][j] == 0) return -1;

                result = Math.max( result , map[i][j]);
            }
        }

        if(result == 1) return 0;
        else return result-1;
    }


}
