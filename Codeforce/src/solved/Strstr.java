package solved;

import java.util.Scanner;

public class Strstr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String needle = scanner.nextLine();
        String haystack = scanner.nextLine();

        System.out.println(Func(needle, haystack));
    }

    public static int Func(String needle, String haystack){
        if(!haystack.contains(needle)) return -1;
        else return haystack.indexOf(needle);
    }
}
