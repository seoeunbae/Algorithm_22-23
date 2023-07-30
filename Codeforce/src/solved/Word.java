package solved;

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Func(s));
    }

    public static String Func(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for(char singleChar : chars){
            if(singleChar >= 65 && singleChar <= 90){
                count++;
            }else{
                count--;
            }
        }
        if(count>0){
            return s.toUpperCase();
        }else return s.toLowerCase();
    }
}
//time complexity: O(알파벳개수 N)
//theme: strings, implementation