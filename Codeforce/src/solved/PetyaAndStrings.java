package solved;

import java.util.Arrays;
import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        System.out.println(Func(firstString, secondString));

    }

    public static String Func(String firstString, String secondString){
        char[] firstCharArray = firstString.toLowerCase().toCharArray();
        char[] secondCharArray = secondString.toLowerCase().toCharArray();
        Integer firstTotalLexical = 0;
        Integer secondTotalLexical = 0;
        if(Arrays.equals(firstCharArray,secondCharArray)){
            return "0";
        } else {
            if(Arrays.compare(firstCharArray,secondCharArray) < 0){
                return "-1";
            } else if(Arrays.compare(firstCharArray, secondCharArray) > 0){
                return "1";
            } else
                return "0";

        }
    }

}
