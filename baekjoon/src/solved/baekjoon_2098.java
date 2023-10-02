package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_2098 {
    static BufferedReader in;
    static StringTokenizer st;

    static int[] distance;
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int INF = 1000001;
    static int min = INF;
    static int[] temp;


    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        map = new int[n][n];
        distance = new int[n];
        visited = new boolean[n];
        temp = new int[n];

        for(int j=0 ; j < n ; j++){
            temp[j] = j;
        }

        for(int i=0 ; i < n ; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            min = Math.min(min,sum(temp));
        } while(next_permutation());

        System.out.println(min);
    }


    private static boolean next_permutation() {
        int i = n - 1;
        while(i > 0 && temp[i - 1] >= temp[i]) --i;
        if(i == 0) return false;

        int j = n - 1;
        while(temp[i - 1] >= temp[j]) --j;

        int tmp = temp[i - 1];
        temp[i - 1] = temp[j];
        temp[j] = tmp;

        int k = n - 1;
        while(i < k) {
            tmp = temp[i];
            temp[i] = temp[k];
            temp[k] = tmp;
            ++i;
            --k;
        }
        return true;
    }

    

    public static int sum(int[] temp){
        int sum = 0;
        int start = temp[0];
        int prev = temp[0];
        for(int i=0 ; i < temp.length ; i++){
                sum += map[prev][temp[i]];
                prev = temp[i];
        }
        sum += map[prev][start];
        return sum;
    }
}
