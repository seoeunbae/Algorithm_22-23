package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class boj_1922_kruskal {
    //1. 크루스칼 알고리즘
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static Edge[] edges;
    static int[] parents;

    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int c;

        Edge(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c-o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parents = new int[n+1];
        edges = new Edge[m]; //간선들

        make(); // 유니온파인드를 위한 초기화

        //입력받기
        for(int i=0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
        }
        //for로 최소 비용 간선부터 순회하면서, 유니온을 할 수 있다면, 실행
        Arrays.sort(edges); // 오름차순 정렬
        int value = 0;
        int edgeCnt = 0;
        for(int i = 0 ; i < edges.length ; i++){
            Edge cur = edges[i];
            if(union(cur.a, cur.b)) {
                value+=cur.c;
                if(++edgeCnt == n-1) {
                    System.out.println(value);
                    break;
                }
            }
        }
    }

    public static void make(){
        for(int i = 1 ; i < parents.length ; i++){
            parents[i] = i;
        }
    }

    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
    public static int find(int x){
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}

