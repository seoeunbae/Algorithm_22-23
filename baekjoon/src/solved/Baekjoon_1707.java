package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1707 {
//    static int N, M;

    static int[] check;

    static boolean bool;
    static Stack<Integer> queue = new Stack<>();
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K  = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++){
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            ArrayList<Integer>[] graph = new ArrayList[V+1];
            Arrays.fill(graph, new ArrayList<>());
            int E = Integer.parseInt(s[1]);
            check = new int[V+1];
            bool = true;
            boolean[] visited = new boolean[V+1];
            for(int j=0 ; j<E ; j++){
                String[] s1 = br.readLine().split(" ");
                int u = Integer.parseInt(s1[0]);
                int v = Integer.parseInt(s1[1]);

                graph[u].add(v);
                graph[v].add(u);
            }

            for(int j = 1 ; j <= V ; j++){
                if(bool){
                    dfs(1, visited, graph);
                } else {
                    break;
                }
            }

            if(bool) System.out.println("YES");
            else System.out.println("NO");


        }




    }

    public static boolean dfs(int j, boolean[] visited,ArrayList<Integer>[] graph){
        System.out.println(j);
        boolean result = true;
        visited[j] = true;
        for(int each : graph[j]){
            if(!visited[each]){
                check[each] = (check[j]+1) % 2;
                dfs(each, visited, graph);
            }
            else if (check[j] == check[each]){
                result = false;
            }
        }
        return result;
    }
}
