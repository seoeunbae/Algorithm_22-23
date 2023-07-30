package solved;

import java.util.Scanner;

public class InSearchOfAnEasyProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String string = scanner.nextLine();
        System.out.println(Func(string));
    }

    public static String Func(String string){
        String[] splits = string.split(" ");
        for(String split: splits){
            if(split.equals("1")) return "HARD";
        }
        return "EASY";
    }
}
