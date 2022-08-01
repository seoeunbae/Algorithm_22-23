package solved;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    public static String Func(String[] strs){
        String result = "";
        String standard = strs[0]; //[flag]
        char[] standardArray = standard.toCharArray();//[f,l,a,g]
        System.out.println(standardArray);
        for(int i=1;i< strs.length;i++){
            if(standard.length() > strs[i].length()) standard = strs[i];
        }
        int length = standard.length();//flow
        for(int i = 1 ; i < strs.length ; i++){ //4
            char[] chars = strs[i].toCharArray(); //[f,l,o,w,e,r]
            System.out.println(chars);

            for(int j = 0 ; j < length ; j++){//5
                System.out.println(standardArray[j]);
                if(standardArray[j] != chars[j]) {
                    standard= standard.substring(0, j);
                    System.out.println(standard);
                } else break;
            }
        }
        System.out.println(standard);
        return standard;

    }
}
