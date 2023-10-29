package greedy.activity_selection_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_19623 {
    static int[][] dp;
    static int[][] times;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>();

        int n = Integer.parseInt(in.readLine());
        times = new int[n][3];
        for(int i=0 ; i < n ; i++){
            String[] s = in.readLine().split(" ");
            times[i][0] = Integer.parseInt(s[0]);
            times[i][1] = Integer.parseInt(s[1]);
            times[i][2]  = Integer.parseInt(s[2]);
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[1];
                }
                return o1[1] - o2[1];
            }
        });

        int size = times[n-1][1];
        System.out.println(size);
        dp = new int[n][size+1];
        int sum = 0;
        for(int i=0 ; i <= size ; i++){ //x 채우기
            if(i >= times[0][0]) dp[0][i] = times[0][2];
        }
        int[] sizes = new int[size+1];
        for(int i=0 ; i <= size ; i++){
            sizes[i]= i;
        }

        int cur = times[0][1]; //끝을 기준
        for(int i=1 ; i < n ; i++ ) {
            for (int j = 1; j <= size; j++) {

                if (j >= times[i][0]) { //겹치는 경우
                    int t = lowerBound(sizes,times[i][0]);
                    System.out.println(t);
                    if(dp[i-1][j] < dp[i-1][t] + times[i][2]){
                        dp[i][j] = dp[i-1][t] + times[i][2];
                    } else dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];

                }
            }
        }
//        for(int i=0 ; i < n ; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[n - 1][size]);
    }

    public static class Room implements Comparable<Room> {
        int st;
        int en;
        int people;
        Room(int st , int en, int people){
            this.st = st;
            this.en = en;
            this.people = people;
        }

        @Override
        public int compareTo(Room room){
            if(this.en == room.en){
                return this.st-room.st;
            }
            return this.en - room.en;
        }
    }

    public static int lowerBound(int[] array,  int value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = low + (high - low)/2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }



}
