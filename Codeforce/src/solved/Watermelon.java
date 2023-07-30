package solved;

import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(Func(input));
    }

    public static String Func(Integer input){
        if(input==2) return "NO";
        else if(input>2 && input%2 == 0) return "YES";
        else return "NO";
    }
}
