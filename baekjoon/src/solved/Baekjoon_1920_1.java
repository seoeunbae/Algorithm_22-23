package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Baekjoon_1920_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");
        Set<Integer> Ns = new TreeSet<>();
        for(int i=0 ; i< split.length ;i++){
            Ns.add(Integer.parseInt(split[i]));
        }

        int M = Integer.parseInt(br.readLine());

        String[] splits = br.readLine().split(" ");
        int[] Ms = Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();

        for(int i=0 ;i < M ; i++){
            if(Ns.contains(Ms[i])) System.out.println("1");
            else System.out.println("0");
        }
    }
}
