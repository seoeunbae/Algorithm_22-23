package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1486 {
    static BufferedReader in;
    static StringTokenizer st;
    static Integer[] array;

    static boolean[] visited;
    static int n;
    static int b;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t ; tc++){
            min = Integer.MAX_VALUE;;
            sb.append("#"+tc).append(" ");
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            visited = new boolean[n];
            array = new Integer[n];
            st = new StringTokenizer(in.readLine());
            for(int i=0 ; i < n ; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            subset(0,0,0, new int[n]);
            sb.append((min-b)+"\n");

        }

        System.out.println(sb.toString());
    }

    public static void subset(int prev, int level, int sum, int[] temp){
        if(level <= n){
            if(sum >= b){
//                System.out.println(Arrays.toString(temp));
                min = Math.min(min, sum);
            }
        }

        for(int i=prev ; i < n ; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[level] = array[i];
                prev = i;
                subset(prev,level+1, sum+array[i], temp);
                visited[i] = false;
            }
        }
    }
}
