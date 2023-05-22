package graph;

import java.io.*;
import java.util.*;

public class FloydWarshal {
    static int N;
    static int M;
    static int[][] board;
    static int INF = (int) 1e9;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM =br.readLine();
        String[] NMs = NM.split(" ");

         N  = Integer.parseInt(NMs[0]);
         M  = Integer.parseInt(NMs[1]);
        board = new int[N+1][N+1];
        int[] array = new int[3];
        for(int i=0 ; i<= N ; i++){
            Arrays.fill(board[i], INF);
        }
        for(int i=0 ; i <= N ; i++){
            for(int j=0 ; j <= N ; j++){
                if(i==j){
                    board[i][j] = 1;
                }

            }
        }

        for(int i=1 ; i <= M ; i++){
            String[] s = br.readLine().split(" ");

            Integer start = Integer.parseInt(s[0]);
            Integer end = Integer.parseInt(s[1]);

            board[start][end] = 1;
            board[end][start] = 1;
        }

        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    board[a][b] = Math.min(board[a][b], board[a][k] + board[k][b]);
                }
            }
        }

        int distance = board[1][K]+ board[K][x];
        if(distance >= INF) System.out.println(-1+"\n");
        else System.out.println(distance);


        ArrayList<String> strings = new ArrayList<>();
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

    }


}
