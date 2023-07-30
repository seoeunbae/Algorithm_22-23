package solved;

import java.util.Scanner;

public class SoldierAndBananas {
    //first banana's price, dollars i have, bananas i should buy
    //->dollars i should barrow
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bananaPrice = scanner.nextInt();
        int dollar = scanner.nextInt();
        int targetCount = scanner.nextInt();
        System.out.println(Func(bananaPrice, dollar, targetCount));
    }

    public static Integer Func(Integer bananaPrice,Integer dollar, Integer targetCount){
        int dollarINeed = 0;
        for(int count = 1;targetCount > 0;targetCount--, count++){
            int currentPrice = bananaPrice*count;
            dollarINeed+=currentPrice;

        }
        if(dollarINeed - dollar > 0){
            return dollarINeed - dollar;
        } else return 0;

    }
}
//시간복잡도: O(필요한 바나나개수 N)
//주제: 브루트포스, 구현