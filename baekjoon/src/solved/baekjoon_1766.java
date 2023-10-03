package solved;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_1766 {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] parents;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] list;

    static int[] indegree;



    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] ins = br.readLine().split(" ");
        n = Integer.parseInt(ins[0]);
        m = Integer.parseInt(ins[1]);
        list = new ArrayList[n+1];
        parents = new int[n+1];
        visited = new boolean[n+1];
        indegree = new int[n+1];
        for(int i=1 ; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }

        for(int i=1 ; i <= n ; i++){
            parents[i] = i;
        }

        for(int i=0 ; i < m ; i++){
            String[] infos = br.readLine().split(" ");
            int a = Integer.parseInt(infos[0]);
            int b = Integer.parseInt(infos[1]);
            list[a].add(b);
            indegree[b] += 1;
        }

        for(int i=1 ; i <= n  ;i ++){
            if(indegree[i] == 0) pq.offer(i);
        }
        while(!pq.isEmpty()){
            Integer poll = pq.poll();
            System.out.print(poll+" ");
            for(Integer each : list[poll]){
                indegree[each]--;
                if(indegree[each]==0){
                    pq.offer(each);
                }
            }

        }

    }

}
