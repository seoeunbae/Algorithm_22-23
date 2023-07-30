package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_3190 {

    static int N;

    static int K;
    static List<int[]> snake = new ArrayList<>();

    static int L;

    static int[][] map;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static final int APPLE = 1;
    static final int SELF = (int) 1e9;
    static HashMap<Integer, String> hash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=0 ; i < K ; i++){
            String[] s = br.readLine().split(" ");
            map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = APPLE;

        }

        L = Integer.parseInt(br.readLine());
        hash = new HashMap<>();

        for(int i=0 ; i < L ; i++){
            String[] s = br.readLine().split(" ");
            hash.put(Integer.parseInt(s[0]), s[1]);
        }


        solve();
    }

    public static void solve() {
        int cx = 1, cy = 1;
        int time = 0;
        int d = 0;
        snake.add(new int[] { 0, 0 });

        while (true) {
            // 1. 시간재기
            time++;

            // 2. 뱀 이동하기
            int nx = cx + dx[d];
            int ny = cy + dy[d];

            // 3. 범위를 벗어나거나, 뱀 몸통 만날 때 종료
            if (isFinish(nx, ny))
                break;

            // 4. 사과가 있을 때 없을 때 처리
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new int[] { nx, ny });

            } else {
                snake.add(new int[] { nx, ny });
                snake.remove(0);
            }

            // 5. 방향을 바꿔주는 시간을 만날 때 방향 변경
            if (hash.containsKey(time)) {
                if (hash.get(time).equals("D")) {
                    d += 1;
                    if (d == 4)
                        d = 0;
                } else {
                    d -= 1;
                    if (d == -1)
                        d = 3;
                }
            }

            // 6. 현재값 업데이트
            cx = nx;
            cy = ny;
            // cx cy 업데이트 위에서
        }

        System.out.println(time);
    }


    public static boolean isFinish(int nx, int ny){
        if (nx <= 0 || ny <= 0 || nx >N || ny > N) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            int[] t = snake.get(i);
            if (nx == t[0] && ny == t[1])
                return true;
        }
        return false;    }
}
