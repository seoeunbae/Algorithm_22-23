package solved;

import java.util.*;

public class DFSBFS_1260 {
    static boolean[] visit;
    static Integer[][] indexMap;
    static Integer N, M ,V;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        N = Integer.valueOf(split[0]);
        M = Integer.valueOf(split[1]);
        V = Integer.valueOf(split[2]);

        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        indexMap = new Integer[N+1][N+1];
        visit = new boolean[N+1];

        for(int i = 0; i<N+1 ; i++){
            Arrays.fill(indexMap[i], 0);
        }
        Arrays.fill(visit, false);
        for(int i=0 ; i<M ; i++){
            String[] edge = scanner.nextLine().split(" ");
            Integer a = Integer.valueOf(edge[0]);
            Integer b = Integer.valueOf(edge[1]);
            indexMap[a][b] = 1;
            indexMap[b][a] = 1;
        }
        dfsFunc(V);
        System.out.println();
        Arrays.fill(visit, false);
        bfsFunc(V);
    }

    public static void dfsFunc(Integer V){
        visit[V] = true;
        System.out.print(V+" ");
        for(int i=1; i<N+1; i++){
            if(indexMap[V][i] == 1 && visit[i] == false){
                dfsFunc(i);
            }
        }

    }

    public static void bfsFunc(Integer V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visit[V] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp+" ");
            for(int i=1;i <= N; i++){
                if(indexMap[temp][i]==1 && visit[i] == false){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
