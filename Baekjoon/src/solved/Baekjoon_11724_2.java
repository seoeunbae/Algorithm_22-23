package solved;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_11724_2 {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    private static void solution () {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N+1];
        list = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            list.get(u).add(v);
            list.get(v).add(u);
        }
        int count = 0;
        for(int i=1; i<N+1; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }


    private static void bfs (int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);

        while(!queue.isEmpty()) {
            int data = queue.poll();
            visited[data] = true;

            for(int i=0; i< list.get(data).size(); i++) {
                int result = list.get(data).get(i);
                if(!visited[result]) {
                    visited[result] = true;
                    queue.add(result);
                }
            }
        }
    }

    public static void main(String[] args) {
        solution();
    }
}

