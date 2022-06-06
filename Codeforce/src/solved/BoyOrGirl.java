package solved;

import java.util.Scanner;
import java.util.TreeSet;

public class BoyOrGirl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(Func(string));
    }

    public static String Func(String string){
        char[] chars = string.toCharArray();
        TreeSet<Character> charSet = new TreeSet<>();
        for(char eachChar: chars){
            charSet.add(eachChar);
        }
        if(charSet.size()%2 == 0){
            return "CHAT WITH HER!";
        } else {
            return "IGNORE HIM!";
        }
    }
}
//time complexity: O(name의 낱말개수)
//theme: brute force, Strings ,implementation