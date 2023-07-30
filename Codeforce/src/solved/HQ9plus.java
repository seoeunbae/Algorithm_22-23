package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HQ9plus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(Func(s));
    }

    public static String Func(String s){
        List<String> hqplus = new ArrayList<>();
        hqplus.add("H");
        hqplus.add("Q");
        hqplus.add("9");
//        hqplus.add("+");

        String[] splits = s.split("");
        for(String split: splits){
            if(hqplus.contains(split)){
                return "YES";
            }
        }
        return "NO";
    }
}
