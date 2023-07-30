package graph;

import java.util.*;

public class BFS {//2개의 큐(방문된 노드, 탐색이 필요한 노드)
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));
        BFSFunc("A", graph);

    }
//큐는 어레이리스트로 구현가능했었다.(add,remove,addAll 사용)
    public static void BFSFunc(String first, HashMap<String, ArrayList<String>> graph){
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> need_visit = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.poll();
        need_visit.add(first);
        int count = 0;
        while(need_visit.size()>0){

            count +=1;
            if(visited.contains(need_visit.get(0))){
                need_visit.remove(0);
                continue;
            } else {
                visited.add(need_visit.get(0));//방문
                need_visit.addAll(graph.get(need_visit.get(0)));//연결노드 방문필요큐에 넣기
                need_visit.remove(0);//하나씩 앞당기기
            }
        }
        System.out.println(visited);
    }
}
//시간복잡도: O(N+V) 노드수+간선수




class Solution {
    static Queue<int[]> queue = new LinkedList<>();
    static long[] result;
    int[][] board;
    boolean[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public long[] solution(int n, int m, int k, int[][] acts) {

        result = new long[k]; //-1해주기
        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=0 ; i < acts.length ; i++){
            int type = acts[i][0]; //[t, x, p]
            int x = acts[i][1];
            int p = acts[i][2];
            if(type == 1){ //행
                for(int j=1 ; j<=m ; j++){
                    board[x][j] = p;
                    // result[p-1]++;
                }

            } else { //2//열-row
                for(int j=1 ; j<=n ; j++){
                    board[j][x] = p;

                    // result[p-1]++;
                }
            }
        }

        // for(int[] row : board){
        //     for(int each : row){
        //         if(each==0) continue;
        //         result[each-1]++;
        //     }
        // }
        bfs(1,1, n, m);
        return result;


    }

    public void bfs(int x, int y, int n, int m){


        queue.add(new int[]{x,y});
        visited[x][y]=true;
        while(!queue.isEmpty()){
            int[] f =queue.poll();
            int fx = f[0];
            int fy = f[1];
            if(board[fx][fy] >= 1) result[board[fx][fy]-1]++;

            for(int i=0; i<4 ; i++){
                int ax = fx+dx[i];
                int ay = fy+dy[i];
                if(ax >= 1 && ax <=n && ay >=1 && ay <=m ){
                    if(!visited[ax][ay]){
                        // bfs(ax,ay,n,m);
                        queue.add(new int[]{ax, ay});
                        visited[ax][ay] = true;

                    }
                }


            }
        }

    }
}