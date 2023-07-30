package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon_1916 {
    static ArrayList<ArrayList<Node>> board = new ArrayList<>();
    static int N;
    static int M;
    static boolean[] visited;
    static int[] distance;

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        distance = new int[N+1];

        for(int i=0 ; i <= N ; i++){
            board.add(new ArrayList<>());

        }
        Arrays.fill(distance, INF);

        for(int i=0 ; i < M ; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            board.get(a).add(new Node(b,c));
        }

        String[] s = br.readLine().split(" ");
        int S = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);

        dijkstra(S);

        System.out.println(distance[E]);
    }

    public static void dijkstra(int k){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        distance[k] = 0;

        while(!pq.isEmpty()){
            Node poll = pq.poll();

            if(visited[poll.end]) continue;

            visited[poll.end] = true;
            for(Node node : board.get(poll.end)){
                if(distance[node.end] > distance[poll.end] + node.weight ){
                    distance[node.end] = distance[poll.end] + node.weight;
                    pq.add(new Node(node.end, distance[node.end]));
                }
            }
        }

    }
    public static class Node implements Comparable<Node>{
        private int end;
        private int weight;

        Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }

}
