package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ExplorerGild {
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        solution(array);
    }

    public static void solution(int[] array){
        int count =0;
        int result = 0;
        Arrays.sort(array);
        for(int i=0 ; i < array.length ; i++){
            count++;
            if( count >= array[i] ){
                result+=1;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
