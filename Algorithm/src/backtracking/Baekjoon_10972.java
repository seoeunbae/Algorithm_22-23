package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Baekjoon_10972 {
    static int N ;

    static ArrayList<ArrayList<Integer>> letters = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
//        char[] chars = br.readLine().toCharArray();
//        for(int i=0 ; i < N ; i++){
//            int current = chars[0] - '0';
//
//
//        }
        ArrayList<Integer> letter= new ArrayList<>();

        permutation(0, letter );
        for(ArrayList<Integer> each : letters){
            for(Integer eachI : each){
                System.out.print(eachI);
            }
            System.out.println();
        }

    }
    static HashSet<Integer> used = new HashSet<>();

    public static void permutation(int level , ArrayList<Integer> letter){
        if(level==N){
            letters.add(new ArrayList<>(letter));
            return;
        }

        for(int i=1 ; i <=  N ;i++) {
            if (used.contains(i)) continue;

            used.add(i);
            letter.add(i);
            permutation(level+1, letter);
            used.remove(i);
            letter.remove(letter.size()-1);
        }


    }
}
