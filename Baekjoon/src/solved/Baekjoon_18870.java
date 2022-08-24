package solved;

import javax.crypto.spec.PBEKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_18870 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

       int[] intX = new int[num];
       int[] origin = new int[num];

       for(int i=0;i<num;i++){
           intX[i] = origin[i] = scanner.nextInt();
       }

        Arrays.sort(intX);
        System.out.println(Func(origin, intX));
    }

    public static String Func(int[] origin, int[] sorted){

        HashMap<Integer, Integer> ranking = new HashMap<>();
        int j=0;
        for(int i=0;i< sorted.length;i++){
            if(!ranking.containsKey(sorted[i])){
                ranking.put(sorted[i], j);
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i< origin.length ;i++){
            sb.append(ranking.get(origin[i])+" ");
        }
        return sb.toString();

    }
}
