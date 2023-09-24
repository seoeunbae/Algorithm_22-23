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
        for(int i=0 ; i < m+1 ; i++){
            PriorityQueue<Shark> pq= new PriorityQueue<>();
            hunter++; //초, 사냥꾼 위치
            int min = 99999999; //가장 땅에 가까운 상어
            int idx = 0;

            for(int j=0 ; j < list.size() ; j++){
                Shark shark = list.get(j);
                shark.r = (shark.r + shark.s * delta[shark.d][0]) % m == 0 ? m : (shark.r +  shark.s * delta[shark.d][0]) % m;
                shark.c = (shark.c + shark.s * delta[shark.d][1]) % n == 0 ? n : (shark.c +  shark.s * delta[shark.d][1]) % n;
                if(map[shark.r][shark.c] > 0){
                    //더 큰 사이즈의 상어가 살아남는다.
                }


                //사냥꾼의 위치에 해당 상어가 있을때
                if(hunter == shark.c) {
                    if(shark.r < min){
                        min = shark.r;
                        idx = j;
                        pq.offer(shark);
                    }

                }
                //가장 땅에서 가까운 상어 잡기

            }
//            if(pq.isEmpty()) continue;
//            Shark poll = pq.poll();
             if(list.isEmpty()) continue;
             ans += list.get(idx).z;
             list.remove(idx);
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
}
