package backtracking;
import java.util.*;

public class next_permutation {
    static boolean[] visited;
    static int n;
    static String[] w ;
    static String ans= "";

    public static void main(String[] args) {
        solution(3, new String[]{"apple", "ele","eee"});
    }
    public static String solution(int N, String[] W) {
        n = N;
        w = new String[n];
        w = W;
        visited = new boolean[N];
        permutation(0,0, new String[N]);
        if (!ans.equals("Yes")){
            ans = "No";
        }
        return ans;
    }

    public static void permutation(int prev, int level, String[] temp){
        if(level == n){
            // boolean same = allSame(temp);
            // if(same)
            ans = "Yes";
            return;
        }

        for(int i=prev ; i < n ; i++){
            if(!visited[i]){
                if (level!=0 && !isSame(temp[level-1], w[i])) continue;
                visited[i] = true;
                temp[level] = w[i];
                prev = i;
                permutation(prev, level+1, temp);
                visited[i] = false;
            }
        }

    }

    public static boolean isSame(String prev, String cur){
        return prev.charAt(prev.length()-1) == cur.charAt(0);
    }

    // public static boolean allSame(String[] strs){
    //     String prev = strs[0];
    //     for(int i=1 ; i < strs.length ; i++){
    //         if(strs[i].equals(null)) return false;
    //         if (prev.charAt(prev.length() - 1) != strs[i].charAt(0)) { return false; }
    //         prev = strs[i];
    //     }
    //     return true;
    // }
}







