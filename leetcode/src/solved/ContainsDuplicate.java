package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Set<Integer> set= new TreeSet<>();

        for(int i=0; i < s.length ;i++){
            set.add(Integer.parseInt(s[i]));
        }

        if (s.length==set.size()){
            System.out.println("false");
        } else System.out.println("true");

    }

}
