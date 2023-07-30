package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon_2252_1 {
    static Integer[] entrArray; //
    static ArrayList<Integer>[] list;
    static  Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        entrArray = new Integer[N+1]; //indegree:진입차수
        list = new ArrayList[N+1];
        for(int i=0 ; i<N+1 ; i++){
            entrArray[i] = 0;
            list[i] = new ArrayList<>();
        }
//        Arrays.fill(entrArray, 0); //fill()-> 시간초과가 난다.
//        Arrays.fill(list, new ArrayList<>());

        for(int i=0 ; i < M ; i++){
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            list[a].add(b);
//            list[b].add(a);
            entrArray[b]++;
        }

        queue = new LinkedList<>();

        for(int i = 1  ; i<= N ; i++){
            if(entrArray[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            sb.append(poll+" ");

            for(int next : list[poll]){
                entrArray[next]--;
                if(entrArray[next] == 0){
                    queue.add(next);
                }
            }
        }
        System.out.println(sb.toString());
    }

}
