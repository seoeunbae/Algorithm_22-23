package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon_11725 {
    static int root = 1;
    static int[] parent;

    static boolean[] isVisit;

    static ArrayList<Integer>[] list;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        isVisit = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i=0 ; i < N+1 ; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i < N-1 ; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            list[a].add(b);
            list[b].add(a);

        }

        dfs(root);

        for(int i=2 ; i< parent.length ; i++){
            System.out.println(parent[i]);
        }

    }

    public static void dfs(int x){
        isVisit[x] = true;
        for(Integer each : list[x]){
            if(!isVisit[each]){
                parent[each] = x;//방문한 적이 없으면 자식노드로 설정하기
                dfs(each);
            }
        }
    }
}
