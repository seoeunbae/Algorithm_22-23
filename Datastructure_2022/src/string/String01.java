package string;

import java.util.Collections;
//문자열뒤집기
public class String01 {
    static String string = "string";


    public static void main(String[] args) {
        char[] chars = string.toCharArray();
        for(int i =0;i<(string.length()-1)/2;i++){
            char charTemp = chars[i];
            chars[i] = chars[string.length()-i-1];
            chars[string.length()-i-1] = charTemp;
        }
        System.out.println(chars);
    }
}
