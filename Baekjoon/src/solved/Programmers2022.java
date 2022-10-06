package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Programmers2022 {
    static HashSet<String> set = new HashSet<>();
    static String N ="" ;
    static String S ="";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String new_id = br.readLine();
        Func(s,new_id);
    }

    public static String Func(String[] registered_list, String new_id){
        set.addAll(Arrays.asList(registered_list));
        char[] newIdChars = new_id.toCharArray();
        for(int i = 0 ; i < newIdChars.length ; i++){
            if(newIdChars[i] <= 57 && newIdChars[i] >= 48){
                // System.out.println(newIdChars[i]);
                N += newIdChars[i];
            } else {
                // System.out.println(newIdChars[i]);
                S += newIdChars[i];
            }
        }

        while (set.contains(new_id)) {
            //N,S 완료
            if(N=="") {
                N="0";
            }
            System.out.println(N);
             Integer n = Integer.valueOf(N);
             Integer n1 = n+1;
             N = String.valueOf(n1);
             System.out.println(N);
             new_id = S.concat(N);
             System.out.println(new_id);
            if( !set.contains(new_id)) return new_id;
        }

        String answer = new_id;
        return answer;


    }
}
