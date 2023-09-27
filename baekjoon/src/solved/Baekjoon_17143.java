package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_17143 {
    static BufferedReader in;
    static StringTokenizer st;
    static int[][] map;
    static int m;
    static int n;
    static int[][] delta = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
    static ArrayList<Shark> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] ins = in.readLine().split(" ");
         n = Integer.parseInt(ins[0]);
         m = Integer.parseInt(ins[1]);
        int sh = Integer.parseInt(ins[2]);
        map = new int[n+1][m+1];
        int ans =0;
        for(int i=0 ; i < sh ; i++){
            String[] s1 = in.readLine().split(" ");
            int r = Integer.parseInt(s1[0]);
            int c = Integer.parseInt(s1[1]);
            int s = Integer.parseInt(s1[2]);
            int d = Integer.parseInt(s1[3]);
            int z = Integer.parseInt(s1[4]);
            Shark shark = new Shark(r,c,s,d,z);
            map[r][c] = z;
            list.add(shark);

        }

        int hunter = 0;
        PriorityQueue<Shark> pq= new PriorityQueue<>();
        for(int i=1; i < m+1 ; i++){
            hunter++; //초, 사냥꾼 위치
            int min = 99999999; //가장 땅에 가까운 상어
            int idx = 0;
            ans += catchShark(i);
            moveSharks();

//            for(int j=0 ; j < list.size() ; j++){
//                Shark shark = list.get(j);
//                map[shark.r][shark.c] = 0;
//                shark.r = (shark.r + shark.s * delta[shark.d][0]) % n == 0 ? n : (shark.r +  shark.s * delta[shark.d][0]) % n; //
//                shark.c = (shark.c + shark.s * delta[shark.d][1]) % m == 0 ? m : (shark.c +  shark.s * delta[shark.d][1]) % m;
//                if(shark.d == 1 || shark.d ==2 ) {
//                    for (int x = 0; x < (shark.r + shark.s * delta[shark.d][0]) / n; x++) {
//
//                    }
//                }else{
//                    for (int x = 0; x < (shark.c + shark.s * delta[shark.d][0]) / m; x++) {
//                    }
//                }
//                if(map[shark.r][shark.c] > 0){
//                    if(map[shark.r][shark.c] > shark.z) {
//                        shark.r = 0;
//                        shark.c = 0;
//                        shark.d = 0;
//                        shark.z = 0;
//                        shark.s = 0;
//                    } else {
//                        map[shark.r][shark.c] = shark.z;
//                    }
//                }
//                else map[shark.r][shark.c] = shark.z;
//
//
//                //사냥꾼의 위치에 해당 상어가 있을때
//                if(hunter == shark.c) {
//                    if(shark.r < min && shark.r > 0){
//                        min = shark.r;
//                        idx = j;
//                        pq.offer(shark);
//                    }
//
//                }
//                //가장 땅에서 가까운 상어 잡기
//
//            }
//            if(pq.isEmpty()) continue;
//            Shark poll = pq.poll();
//             if(list.isEmpty()) continue;
//             ans += list.get(idx).z;
////             list.remove(idx);
//            list.get(idx).r = 0;
//            list.get(idx).c = 0;
//            list.get(idx).d = 0;
//            list.get(idx).s = 0;
//            list.get(idx).z = 0;
//            ans += pq.poll().z;
//            System.out.println(list.size());
        }

        System.out.println(ans);
    }

    public static class Shark implements Comparable<Shark>{
        int r;
        int c;
        int s;
        int d;
        int z;

        Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c=c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            return this.r - o.r; //오름차순
        }
    }

    static int catchShark(int col) {
        int size = 0;

        for (int row = 1; row <= n; row++) {
            if (map[row][col] > 0) {
                size = map[row][col];
                map[row][col] = 0;
                for (Shark shark : list) {
                    if (shark.r == row && shark.c == col) {
                        list.remove(shark);
                        break;
                    }
                }
                break; // Only one shark can be caught in this column.
            }
        }

        return size;
    }


    static void moveSharks() {
        int[][] newMap = new int[n + 1][m + 1];

        for (Shark shark : list) {
            int r = shark.r;
            int c = shark.c;
            int s = shark.s;
            int d = shark.d;

            map[r][c] = 0;

            while (s > 0) {
                r += s * delta[d][0];
                c += s * delta[d][1];

                if (r < 1) {
                    r = 2 - r;
                    d = 2;
                } else if (r > n) {
                    r = 2 * n - r;
                    d = 1;
                } else if (c < 1) {
                    c = 2 - c;
                    d = 3;
                } else if (c > m) {
                    c = 2 * m - c;
                    d = 4;
                }

                s = 0;
            }

            if (newMap[r][c] == 0 || newMap[r][c] < shark.z) {
                newMap[r][c] = shark.z;
                shark.r = r;
                shark.c = c;
                shark.d = d;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }



}
