package solved;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Palindrome {
    static String temp;
    static String s;
    static String result ="";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int integer = scanner.nextInt();
        System.out.println(isPalindrome(integer));
    }

    public static boolean isPalindrome(int x){
        s = String.valueOf(x);
        if(s.length()==1) return true;
        String[] splits = s.split("");
        for(int i=0 ; i <= (splits.length/2)-1 ; i++){
            temp = splits[i];
            splits[i] = splits[splits.length-i-1];
            splits[splits.length-i-1] = temp;
        }

        for(String split: splits){
            result=result.concat(split);
        }
        System.out.println(result);
        return s.equals(result);

    }
}
//integer를 string으로 바꾼 뒤, 문자열 뒤집기를 한뒤 동일성비교를 한다.
//1. integer->string array변환
//2. temp를 활용한 문자열 뒤집기
//3. String 합쳐서 String으로 만들기
//4. 뒤집은 문자열과 원래 입력값의 동일성 비교
