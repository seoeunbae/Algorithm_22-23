package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11403 {

    static int[][] board ;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0 ; i < N ; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0 ; j <s.length ; j++){
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int k=0 ; k < N ; k++){
            for(int a=0 ; a< N ; a++){
                for(int b=0 ; b<N ;b++){
                    if(board[a][k] == 1 && board[k][b] == 1){
                        board[a][b] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < N ; i++){
            for(int j=0 ; j < N ; j++){
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
