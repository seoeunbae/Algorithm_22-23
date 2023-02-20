package problem_solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char[] strs = str.toCharArray();

        for(int i = 0 ; i < strs.length / 2 ; i++){
            char temp = strs[i];

             strs[i] = strs[strs.length-i-1];
             strs[strs.length-i-1] = temp;

        }

        System.out.println(strs);
    }
}
