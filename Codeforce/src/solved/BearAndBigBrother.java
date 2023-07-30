package solved;

import java.util.Scanner;

public class BearAndBigBrother {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limak = scanner.nextInt();
        int bob = scanner.nextInt();
        System.out.println(Func(limak, bob));
    }

    public static Integer Func(Integer limak, Integer bob){
        Integer year = 0;
        while(limak <= bob){
            limak *= 3;
            bob *= 2;
            year++;
        }
        return year;
    }
}
// 시간복잡도: O(year)
// 주제: 구현