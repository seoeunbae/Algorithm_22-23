package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_15649 {
    static Integer N;
    static Integer M;
    static HashSet<Integer> used = new HashSet<>();
    static ArrayList<ArrayList<Integer>> total_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> temp_list= new ArrayList<>();
        backtracking(0, temp_list);
    }

    public static void backtracking(int level, ArrayList<Integer> list){
        if (level==M){
            for(Integer each: list){
                System.out.print(each+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1 ; i <=N ; i++){
            if (used.contains(i)){
                continue;
            }
            used.add(i);
            list.add(i);
            backtracking(level+1, list);
            list.remove(list.size()-1);
            used.remove(i);
        }
    }
}
