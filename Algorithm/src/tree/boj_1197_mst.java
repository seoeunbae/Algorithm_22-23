package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1197_mst {
    static BufferedReader in;
    static StringTokenizer st;
    static int v;
    static int e;
    static int[] parents;
    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int c;
        Edge(int from, int to, int c){
            this.from = from;
            this.to = to;
            this.c = c;
        }


        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        String[] str = in.readLine().split(" ");
        v = Integer.parseInt(str[0]);
        e= Integer.parseInt(str[1]);
        parents = new int[v+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=1 ; i <= v ; i++){
            parents[i] = i;
        }

        for(int i=0 ; i < e ; i++){
            String[] ins = in.readLine().split(" ");
            int a = Integer.parseInt(ins[0]);
            int b = Integer.parseInt(ins[1]);
            int c = Integer.parseInt(ins[2]);
            Edge edge = new Edge(a,b,c);
            pq.offer(edge);
        }
        int ed = 0;
        int cost = 0;
        //오름차순 정렬하기
        for(int i=0 ; i < e ; i++){
            Edge poll = pq.poll();
            if(union(poll.from, poll.to)){
                ed++;
                cost+=poll.c;

                if(ed == v-1){
                    break;
                }
            }
        }
        System.out.println(cost);
    }

    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);

    }
}
