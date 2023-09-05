package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_14575 {
    static BufferedReader br;
    static StringTokenizer st;
    static int n;
    static int t;

    static ArrayList<int[]> persons = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        t = Integer.parseInt(str[1]);
        for(int i = 0 ; i < n; i++){
            String[] s = br.readLine().split(" ");
            int L = Integer.parseInt(s[0]);
            int R = Integer.parseInt(s[1]);
            persons.add(new int[]{L,R});
        }
        int hi = t;
        int lo = 0;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int sum = getSum(mid);
            System.out.println(sum);
            if (sum == t){
                ans.add(mid);
                return;
            }
            else if(sum > t){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        System.out.println(ans.size());
    }

    public static int getSum(int std){
        int sum = 0;
        for(int[] each : persons){
            if(std < each[0]){
                return -1;
            } else if(std == each[0]){
                sum += each[0];
            } else if(std < each[1]){
                sum += std;
            } else if(std > each[1]){
                sum += each[1];
            }
        }
        return sum;
    }
}
