package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_11404 {
    static int N;
    static int M;
    static int[][] board;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        board= new int[N][N];
        for(int i=0 ; i<N ; i++){
            Arrays.fill(board[i] , INF);
        }
        for(int i=0 ; i < N ; i++){
            for(int j=0 ; j < N ; j++){
                if(i==j){
                    board[i][j] = 0;
                }

            }
        }

        //플로디읃 워셜
        for(int i = 0 ; i < M ; i++){


            String[] s = br.readLine().split(" ");
            int start= Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);

            board[start-1][end-1] = Math.min(board[start-1][end-1] , weight);
//            board[start-1][end-1] = weight;

        }
        StringBuilder sb = new StringBuilder();
        for(int k = 0 ; k < N ; k++){
            for(int a = 0 ; a < N ; a++){
                for(int b = 0 ; b < N ; b++){
                    board[a][b] = Math.min(board[a][b], board[a][k] + board[k][b]);
                }
            }
        }

        for(int i=0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(board[i][j] == INF) {
                    board[i][j] = 0;
                }
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
