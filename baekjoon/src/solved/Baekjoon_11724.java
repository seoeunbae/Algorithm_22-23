package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon_11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] G;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);//정점
        int M = Integer.parseInt(s[1]);//간선
        visited = new boolean[N+1];
        G = new ArrayList[N+1];
        for(int i=0 ; i < M; i++){
            String[] s1 = br.readLine().split(" ");
            int I = Integer.parseInt(s1[0]);
            int J = Integer.parseInt(s1[1]);
            G[I] = new ArrayList<>();
            G[J] = new ArrayList<>();
            G[I].add(J);
            G[J].add(I);
        }

        for(int i=1 ; i <= N ; i++){
            if( !visited[i] ) {
                System.out.println("i : "+ i);
                cnt++;
                dfs(i,G[i]);
            }
            System.out.println("already viisted : " + i);
        }

        System.out.println(cnt);
    }

    public static void dfs(int cur, ArrayList<Integer> currentG){
        visited[cur] = true; //1,5 ,2,4,3
        for(int next : currentG){  //2

            if( !visited[next]){ //2-true, 4-true
                System.out.println(next +" == "+currentG); //5 , 4,2, 3
//                cnt++;//1
                dfs(next, G[next]);// 5,(2,4) / 4 , (3,6,2) / 2, (3) / 3, (2,4)
            }
            System.out.println("next : " + next);
        }
        System.out.println("out");
    }
}
