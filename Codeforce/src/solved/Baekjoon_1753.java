package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_1753 {
    static int V;
    static int E;
    static int K;
    static int[] distance;

    static final int INF = (int) 1e9;
    static boolean[] visited;

    static ArrayList<ArrayList<Node>> board = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        K = Integer.parseInt(br.readLine()); // start node
        distance = new int[V+1];
        visited = new boolean[V+1];

        for(int i=0 ; i <= V ; i++){ //1 ~ V
            board.add(new ArrayList<>());
        }

        Arrays.fill(distance, INF);
        for(int i=0 ; i < E ; i++){
            String[] s1 = br.readLine().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            int w = Integer.parseInt(s1[2]);

            board.get(u).add(new Node(v,w));

        }

        dijkstra(K);


    }

    public static void dijkstra(int K){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Node(K,0));
        distance[K] = 0;
        while(!pq.isEmpty()){

            Node selected = pq.poll(); //K,0
            if(visited[selected.end]) continue;
            visited[selected.end] = true;
            for( Node node : board.get(selected.end) ){
                if(distance[node.end] > distance[selected.end] + node.weight ){
                    distance[node.end] = distance[selected.end] + node.weight;
                    pq.add(new Node(node.end , distance[node.end]));
                }
            }
        }
        StringBuilder sb  = new StringBuilder();
        for(int i=1 ; i < distance.length ; i++){
            if(distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i]).append("\n");
        }

        System.out.println(sb.toString());

    }
    public static class Node implements Comparable<Node>{
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }


    }
}
