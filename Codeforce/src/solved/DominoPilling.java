package solved;

import java.util.Scanner;

public class DominoPilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        Integer width = M*N;
        System.out.println(width/2);
    }
}
