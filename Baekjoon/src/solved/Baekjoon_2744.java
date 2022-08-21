package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input= br.readLine();

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(Character.isUpperCase(c)){
                System.out.print(String.valueOf(c).toLowerCase());
            } else{
                System.out.print(String.valueOf(c).toUpperCase());
            }
        }
    }
}
