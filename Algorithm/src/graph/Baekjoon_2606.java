package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon_2606 {
    static int[][] edgeBoard ;
    static int E;
    static int N;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        edgeBoard = new int[N+1][N+1];
        visited = new boolean[N+1];
        //간선 초기화
        for(int i=0 ; i < E ; i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.valueOf(s[0]);
            int y = Integer.valueOf(s[1]);

            edgeBoard[x][y] = 1;
            edgeBoard[y][x] = 1;

        }
        //자기자신 초기화
//        for(int i=1 ; i <= N ; i++){
//            board[i][i] = 0;
//        }

        bfs(1);

    }

    public static void bfs(int index){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(index);
        visited[index] = true;

        while(!pq.isEmpty()){
            int poll = pq.poll();


//            int x = poll[0]; //1
//            int y = poll[1]; //1
            for(int i=1 ; i < edgeBoard[poll].length ; i++){
                if(edgeBoard[poll][i] == 1 && !visited[i]){

                    pq.add(i);
                    count++;
                    visited[i] = true;
                }
            }
        }
        System.out.println(count);

    }
}
