package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_11724_1 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); //정점개수
        int M = Integer.parseInt(NM[1]); //간선개수

        graph = new ArrayList[N+1];
        Arrays.fill(graph, new ArrayList<>());
        visited = new boolean[N+1];

        for(int i=0 ; i < M ; i++){
            String[] s1 = br.readLine().split(" ");
            int s = Integer.parseInt(s1[0]);
            int e = Integer.parseInt(s1[1]);

            graph[s].add(e);
            graph[e].add(s);
        }
        int count = 0;
        for(int i=1 ; i<= N ;i++){
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int index){
//        if(visited[index]) return;
        Queue<Integer> queue = new LinkedList<>();
//        visited[index] = true;
        queue.add(index);

        while(!queue.isEmpty()){
            Integer polled = queue.poll();
            visited[polled]= true;
            for (int i=0 ; i < graph[polled].size() ; i++){
                Integer integer = graph[polled].get(i);
                if(!visited[integer] )  {
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }


}
