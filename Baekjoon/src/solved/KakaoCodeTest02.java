package solved;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoCodeTest02 {
    static boolean[] visited;
    static int distance;
    static int carry;

    public static void main(String[] args) {

    }


    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        visited = new boolean[n];
        bfs(0, cap, n , deliveries, pickups);
        return distance;
    }

    public static int bfs(int v,int cap, int n, int[] deliveries, int[] pickups){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            visited[poll] = true;
            carry = deliveries[poll]+pickups[poll];
            for(int i=0 ;i<n;i++){
                if(deliveries[i] == 0 || pickups[i] == 0) continue;
                if(visited[i]) continue;

                queue.add(i);
                visited[i]=true;
                distance += Math.abs(poll-i);
                if( carry > cap){
                    distance+=n;
                    carry = 0;
                }
           }
        }
        return distance;
    }

}