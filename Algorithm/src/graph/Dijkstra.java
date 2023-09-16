package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {

    static int N;
    static int M;
    static int C;
    static boolean[] visited;
    static int[] distance;

    static ArrayList<ArrayList<Node>> board = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); //노드개수
        M = Integer.parseInt(s[1]); //간선개수
        C = Integer.parseInt(s[2]); //스타트노드
        visited = new boolean[N+1];
        distance= new int[N+1];
        for(int i=0 ; i <= N ; i++){
            board.add(new ArrayList<>());
        }
        //간선 초기화
        for(int i=1 ; i <= M ; i++){
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);
            int weight = Integer.parseInt(edge[2]);
            board.get(start).add(new Node(end, weight));
        }

        dijkstra(C);
    }

    public static void dijkstra(int c){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.edge));

        for(int i=0 ; i <= N ; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        pq.add(new Node(c, 0));
        distance[c] = 0;


        while(!pq.isEmpty()){
            Node poll = pq.poll();
            int edge = poll.edge;
            //0
            int start = poll.index;
            //c
            if(visited[start]) continue;
            //간선정보 :
            visited[start] = true;
            for(Node end : board.get(start)){
                int cost = edge + end.edge;
                if(cost < distance[end.index]){
                    distance[end.index] = cost;
                    pq.add(new Node(end.index , distance[end.index]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < distance.length ; i++){
            if(distance[i] == Integer.MAX_VALUE || distance[i] == 0) continue;

            sb.append(distance[i]).append(" ");

        }
        System.out.println(sb.toString());
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
