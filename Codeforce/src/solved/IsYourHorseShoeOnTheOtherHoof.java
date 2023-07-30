package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IsYourHorseShoeOnTheOtherHoof {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int count =0;

        int[] ints = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        for(int i=0 ; i<ints.length-1 ; i++){
            if(ints[i] == ints[i+1]) count++;
        }

        System.out.println(count);


    }

    public static void Func(){

    }

}
