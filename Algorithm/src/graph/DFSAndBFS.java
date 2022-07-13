package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFSAndBFS {
    static int n;
    static int edgeNum; //간선의 개수
    static int start;

    static int[][] check;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        edgeNum = scanner.nextInt();
        start = scanner.nextInt();

        check = new int [1001][1001];
        visited = new boolean[1001];

        for(int i=1;i<=edgeNum;i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            check[v1][v2] = check[v2][v1] = 1; //true방문함
        }

        dfs(start);
        visited = new boolean[1001];
        System.out.println();
        bfs();
    }

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for(int j=1;j<=n;j++){
            if(check[start][j]==1 && visited[j] == false) {
                dfs(j);
            }
        }
    }

    public static class Queue<T>{
        private List<T> queue = new ArrayList<>();

        public List<T> add(T element){
            queue.add(element);
            return queue;
        }
        public List<T> dequeue(){
            if(queue.isEmpty()){
                return null;
            } else{
                queue.remove(0);
                return queue;
            }
        }


    }

    public static void bfs(){
        Queue<Integer> queue = new Queue<>();
        queue.add(start);
        visited[start] = true;
        System.out.print(start+ " ");
        while(!queue.queue.isEmpty()){
            int temp = queue.queue.remove(0);
            for(int j=1;j<=n;j++){
                if(check[temp][j] == 1 && visited[j] == false){//
                    queue.queue.add(j);
                    visited[j]=true;
                    System.out.print(j+ " ");
                }

            }
        }
    }
}


