package solved;

import java.util.Arrays;
import java.util.Scanner;

public class Translation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        if(Func(s,t)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }
    public static Boolean Func(String s, String t){
        char[] sArray = s.toCharArray();
        for(int i =0; i<= (sArray.length-1)/2 ; i++ ){
            char sTemp = sArray[i];
            sArray[i] = sArray[sArray.length-1-i];
            sArray[sArray.length-1-i] = sTemp;
        }

        return t.equals(String.copyValueOf(sArray));

    }
}
//O(logn)
//구현