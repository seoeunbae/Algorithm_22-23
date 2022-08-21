package solved;

import java.util.Scanner;

public class wordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Func(scanner.nextLine());
    }

    public static void Func(String string){
        System.out.println(string.length());
    }
}
