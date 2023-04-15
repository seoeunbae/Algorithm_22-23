package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    static int N;
    static int M;
    static int C;
    static boolean[] visited;
    static int[] distance;

    static ArrayList<ArrayList<Node>> board;

    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        C = Integer.parseInt(s[2]);

        for(int i=0 ; i <= N ; i++){
            board.add(new ArrayList<>());
        }
        //간선 초기화
        for(int i=1 ; i <= M ; i++){
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[0]);
            int weight = Integer.parseInt(edge[0]);

            board.get(start).add(new Node(end, weight));
        }

        dijkstra(C);
    }

    public static void dijkstra(int c){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N+1];
        distance= new int[N+1];
        distance[c] = 0;
        pq.add(board.get(c).get(0));
        while(!pq.isEmpty()){
            Node poll = pq.poll();

        }
    }

    public static class Node implements Comparable<Node>  {

        private int index;
        private int edge;

        Node(int index, int edge){
            this.index = index;
            this.edge = edge;
        }

        @Override
        public int compareTo(Node o) {
            return this.edge - o.edge;
        }


    }


}
