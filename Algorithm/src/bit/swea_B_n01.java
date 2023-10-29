package bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_B_n01 {
    static BufferedReader in;
    static int[] array;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine());
        for(int t=1; t <= tc ; t++){
            String s = in.readLine();//1
            int n = Integer.parseInt(s);
            int i= 0;
            int visit = 0;
            boolean[] visited = new boolean[10];

            int total = (1<<10) - 1;
            int count = 0;
            for (count=1;; count++) {
                char[] arr = String.valueOf(n * count).toCharArray();  // N*count 값을 문자열로 표현한 것  (예: 5 * 13 = 65 -> "65")
                for( char c :arr){
                    int num = c - '0';
                    visit = visit | (1 << num);  // 각 숫자에 대해 등장했다는 의미로 bit 를 1로 변경

                    visited[num] = true;
                }

                if (visit == total) break;  // 모든 숫자가 등장했다면, 종료

                boolean flag = true;
                for (int k=0;k<=9;k++){
                    if (visited[k] == false) flag = false;
                }
                if (flag) break;
            }
            System.out.println(n*count);
        }

    }
}
