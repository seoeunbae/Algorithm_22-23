package solved;

import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s){
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}
