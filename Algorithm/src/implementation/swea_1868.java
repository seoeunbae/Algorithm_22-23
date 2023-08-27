package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1868 {
    static int T;
    static BufferedReader br;
    static StringBuilder sb;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] mineMap;

    static int ans;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{1,-1},{1,1},{-1,1}};

    public static void main(String[] args) throws IOException {
        br= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t = 1 ; t <= T ; t++){
            sb.append("#").append(t).append(" ");
            ans=0;

            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            mineMap = new int[n][n];
            visited = new boolean[n][n];
            for(int i=0 ; i < n ; i++){
                String s = br.readLine();
                for(int j=0 ; j < n ;j ++){
                    Character temp = s.charAt(j);
                    if(temp.equals('.')) map[i][j] = -1; //미확인
                    if(temp.equals('*')) map[i][j] = -2; //지뢰
                    //0 : 클릭 후 표시
                }
            }

            countMine();

            for(int i=0; i < n ; i++){
                for(int j=0 ; j < n ; j++){
                    if(map[i][j] == -1 && !visited[i][j]) {
                        click(i,j);
                        ans++;
                    }
                }
            }

            // 아직 눌리지 않은 곳이 있다면 눌러주자.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 주변에 지뢰가 있지만 현 위지가 지뢰가 아니라면
                    if(map[i][j] == -1){
                        ans++;
                    }
                }
            }


            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }


    public static void countMine(){
        for(int i=0 ; i < n ;i++){
            for(int j=0 ; j < n ;j++){
                if(map[i][j] != -2) mineMap[i][j] = isZero(i,j);
            }
        }
    }

    public static int isZero(int y,int x){
        boolean[][] visit = new boolean[n][n];
        int bomb=0;

        for(int i=0 ; i < 8 ; i++){
            int ay = y + deltas[i][0];
            int ax = x + deltas[i][1];
            if (inRange(ay,ax) && !visit[ay][ax] ){
                if(map[ay][ax] == -2){  //
                    visit[ay][ax] = true;
                    bomb++;
                }
            }
        }
        return bomb;

    }
    public static void click(int y, int x){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            //주변 지뢰 세기
            int temp = mineMap[poll[0]][poll[1]];
            map[poll[0]][poll[1]] = temp;
            for(int i=0 ; i < 8  ; i++){
                int ay = poll[0] + deltas[i][0];
                int ax = poll[1] + deltas[i][1];

                if(inRange(ay,ax) && map[ay][ax] != -2 ){
                    int zero = mineMap[ay][ax]; //2
                    if (temp == 0) {
                        map[ay][ax] = zero; //부모가 0 이었으면, 숫자표시넣기 /아직-1
                        continue;
                    }
                    if(!visited[ay][ax]) {
                        visited[ay][ax] = true;
                        if (zero == 0) { // 0인 경우 큐에 넣기
                            map[ay][ax] = 0;
                            queue.add(new int[]{ay, ax});
                        }
                    }
                }
            }

        }
    }



    public static boolean inRange(int y, int x){
        return y >= 0 && x >= 0 && x < n && y < n ;
    }
}
