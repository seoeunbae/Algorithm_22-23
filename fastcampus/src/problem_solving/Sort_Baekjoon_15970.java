package problem_solving;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sort_Baekjoon_15970 {
    static ArrayList<ArrayList<Integer>> colorList = new ArrayList<>();




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());

        for(int i=0 ; i<= num ; i++){
            colorList.add(new ArrayList<>());
        }


        for(int i = 0 ; i < num ; i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int color = Integer.parseInt(s[1]);

            colorList.get(color).add(x);
        }

        for (int i = 0; i <= num; i++) {
            Collections.sort(colorList.get(i));
        }
        int sum = 0;
        for(ArrayList<Integer> eachColorList : colorList){
            for(int i=0 ; i< eachColorList.size() ; i++){
                if( i == 0) {
                    sum += eachColorList.get(1) - eachColorList.get(0);
                }
                else if(i == eachColorList.size() - 1 ){
                    sum += eachColorList.get(i) - eachColorList.get(i - 1);
                }
                 else {
                    sum += Math.min(eachColorList.get(i)-eachColorList.get(i-1), eachColorList.get(i+1)-eachColorList.get(i));
                }
            }
        }

        System.out.println(sum);
    }



}
