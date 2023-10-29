package greedy.activity_selection_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] times = new int[n][2];
        for(int i=0 ; i < n ; i++){
            String[] ins = in.readLine().split(" ");
            times[i][0] = Integer.parseInt(ins[0]);
            times[i][1] = Integer.parseInt(ins[1]);
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                } else return o1[1] - o2[1];
            }
        });

        int cnt =0 ;
        int prev = 0;
        for(int i=0 ; i < n ; i++){
            if(prev <= times[i][0]) {
                cnt++;
                prev = times[i][1];
            }
        }
        System.out.println(cnt);
    }
}
