package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1916 {
    static List<Integer>[] map;
    static boolean[] visited;
    static int[] distance;
    static int N ;
    static int M;

    static final int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Integer M = Integer.parseInt(br.readLine());
        map = new List[N+1];

        for(int i=1 ; i <= N ; i++){
            map[i] = new ArrayList<>();
        }

        for(int i=0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[node].add(endNode, dist);
        }



    }

    public static void dijkstra(int start){
        for(int i=1 ; i <= N ; i++){
            distance[i] = INF;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        distance[start] = 0;
        visited[start] =true;
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            visited[poll[0]] = true;
            // 거리정보 갱신

        }

    }

}
