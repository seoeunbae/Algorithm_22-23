package solved;

import java.util.Scanner;

public class NearlyLuckyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(Func(string));
    }

    public static String Func(String string){
        int count =0;
        String luckyNum = "47";
        String[] splits = string.split("");
        for(String split: splits){
            if(luckyNum.contains(split)){
                count+=1;
            }
        }
        if(count == 4 || count == 7 ){
            return "YES";
        } else return "NO";

    }
}
