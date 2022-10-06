package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1759 {
    static Queue<String> aeiou = new LinkedList<>();
    static Queue<String> consonant = new LinkedList<>();
    static List<String> list = new ArrayList<>(Arrays.asList("a", "e", "i" ,"o", "u"));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        Integer L = Integer.parseInt(strings[0]);
        Integer C = Integer.parseInt(strings[1]);
        String[] s = br.readLine().split(" ");

        for(int i=0 ; i< C ; i++){
            if(list.contains(s[i])){
                aeiou.add(s[i]);
            } else {
                consonant.add(s[i]);
            }
        }


    }

    public static void Func(){

    }
}
