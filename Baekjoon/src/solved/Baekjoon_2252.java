package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2252 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=0 ; i< graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        Integer[] D = new Integer[N+1];
        Arrays.fill(D, 0);

        for(int i = 1; i<M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ahead = Integer.parseInt(st.nextToken());
            int behind = Integer.parseInt(st.nextToken());
            graph[ahead].add(behind);

            D[behind]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i =1 ; i < N+1 ; i++ ){
            if(D[i] == 0){
                queue.add(i);
            }
        }
        Integer[] result = new Integer[N+1];
        for(int i = 1 ; i< N ; i++){
            if(queue.isEmpty()){
                break;
            }
            Integer peek = queue.peek();
            queue.poll();
            result[i] = peek;
            for(int j = 0 ; j < graph[peek].size() ; j++){
                Integer edge = graph[peek].get(j);
                if(--D[edge] == 0 ){
                    queue.add(edge);
                }
            }
        }

        for(int i=0 ; i < result.length ; i++){
            System.out.println(result[i]);
        }



    }


}
