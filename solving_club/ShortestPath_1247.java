package solving_club;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class ShortestPath_1247 {
    static final int INF = 10001;
    static BufferedReader br;
    static int[] COMPANY;
    static int[] HOME;
    static int[][] board;
    static boolean[] check;

    static int answer = 0;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= (N*2) + 2; i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                //각 인데스의좌표 저장
                if (i == 1){ // 0
                    COMPANY = new int[]{x,y};
                    list.add(COMPANY);
                }
                else if(i==2){ // N+1
                    HOME = new int[]{x,y};
                }
                else {// 1~N
                    list.add(new int[]{x, y});    // 손님 idx => 0부터 n-1까지
                }
            }
            list.add(HOME);

            // 초기화함
            for(int i=0 ; i < N+2 ; i++){ // i출발지 j도착지
                for (int j= 0 ;j<N ; j++){
                    if (i==j){
                        board[i][j]=0;
                    } else {
                        int[] start = list.get(i);
                        int[] dest = list.get(j);
                        int dist = Math.abs(start[0] - dest[0]) + Math.abs(start[1] - dest[1]);
                        board[i][j] = dist;
                    }
                }
            }
            //노드간 거리 구함
//            for(int i=0 ; i < N+2 ; i++) {
//                for (int j = 0; j < N + 2; j++) {
//                    for (int k = 0; k < N + 2; k++) {
//                        if (board[i][j] > board[i][k] + board[k][j]) {
//                            board[i][j] = board[i][k] + board[k][j];
//                        }
//                    }
//                }
//            }
            //각각 최단경로 구함


        }

    }
    //start==0
    //end==N+1
    public static void dfs(int x, int N){
        Stack<Integer> stack = new Stack<>();
        stack.add(x);

        while(!stack.isEmpty()){
            Integer pop = stack.pop();

            if (check[pop]){
                continue;
            }

            check[pop] = true;
            int min = 0;
            int min_idx= 0;
            for(int i = 0 ; i < N+1 ; i++){
                if (!check[i]){
                    if (min > board[pop][i]){
                        min = board[pop][i];
                        min_idx = i;
                    }
                }
            }
            //min 정해짐
            stack.add(min_idx);


        }
    }




}
