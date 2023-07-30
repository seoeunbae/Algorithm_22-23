package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon_18352 {

    static int[] distance;
    static boolean[] visited;
    static final int INF = (int) 1e9;
    static int N;
    static int K;
    static  ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] chars= br.readLine().split(" ");

        N = Integer.parseInt(chars[0]);
        int M = Integer.parseInt(chars[1]);

        K = Integer.parseInt(chars[2]);
        int S = Integer.parseInt(chars[3]);



        distance = new int[N+1];


        visited = new boolean[N+1];

        for(int i=0 ; i <= N ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0 ; i < M ; i ++){
            String[] s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            adjList.get(A).add(B);
        }

        dijkstra(S);
    }

    public static void dijkstra(int S){

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i=0 ; i <= N ; i++){
            distance[i] = INF;
        }
        queue.add(S);
        distance[S] = 0;

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            if(visited[poll]) continue;
            visited[poll] = true;
            for(Integer integer : adjList.get(poll)){
                int cost = 1 + distance[poll];
                if(cost < distance[integer]){
                    distance[integer] = cost;
                    queue.add(integer);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=1 ; i <=  N ; i++){
            if(distance[i] == K ){
                cnt++;
                sb.append(i).append("\n");
            }

        }
        if(cnt == 0) sb.append("-1");
        System.out.println(sb.toString());
    }
}
