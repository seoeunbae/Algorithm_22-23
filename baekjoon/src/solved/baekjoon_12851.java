package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon_12851 {
    static BufferedReader in;
    static int n;
    static int k;
    static int min = 100000;
    static int cnt = 0;
    static boolean[] visited;
    static int[] idxs = {0, 0, 0};
    static int[] times;
    //시간배열을 따로 써서, visited한 경우에도 통과하는 경우를 만들어준다.
    //visited한 경우에도 통과하는 경우 = 이전 방문과 방문시간이 동일한 경우!
    //이유 : 더 최단 시간이 나올수있는 가능성이 있기 때문이다.
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        visited = new boolean[100000*2];
        times = new int[100000*2];

        bfs(n);
        System.out.println(min);
        System.out.println(cnt);

    }

    public static void bfs(int x){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int poll = q.poll();
            int time = times[poll];

            if(poll == k){
                if(min == time){
                    cnt++;
                }
                else if(min > time) {
                    min = time;
                    cnt = 1;
                }
            }

            if(time > min) {
                continue;
            }

            idxs[0] = poll+1;
            idxs[1] = poll-1;
            idxs[2] = poll*2;
            for(int i=0 ; i < idxs.length ; i++){
                if(idxs[i] >= 0 && idxs[i] < Math.max(n,k)*2){
                    if(!visited[idxs[i]] || times[poll] + 1 == times[idxs[i]]  ) {
                        times[idxs[i]] = times[poll] +1;
                        q.offer(idxs[i]);
                        visited[idxs[i]] = true;
                    }
                }
            }
        }
    }
}
