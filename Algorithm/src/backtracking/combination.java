package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class combination {
    static int N;
    static int M;

    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine();
        N = s.charAt(0)-'0';
        M = s.charAt(2)-'0';

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> combi = new ArrayList<>();
        for(int i=0 ; i < N ; i++){
            combi.add(i+1);
        }

        combination(1,combi, list);

        for(ArrayList<Integer> listEach : lists){
            for(Integer each :listEach){
                System.out.print(each+" ");
            }
            System.out.println();
        }
    }
    static HashSet<Integer> used = new HashSet<>();
    public static void combination(int prevIndx ,ArrayList<Integer> combi, ArrayList<Integer> currentCombi){
        if(currentCombi.size() == M){
            lists.add(new ArrayList<>(currentCombi));
            return;
        }

        for(int i=prevIndx ; i<=combi.size() ; i++){
            int num = combi.get(i-1);
            if(used.contains(num)) continue;

            currentCombi.add(num);
            used.add(num);
            combination(num,combi,currentCombi);
            currentCombi.remove(currentCombi.size()-1);
            used.remove(num);
        }

    }
}
