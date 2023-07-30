package solved;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Twins {
    static int n;;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        String[] splits = scanner.nextLine().split(" ");
        System.out.println(Func(n ,splits));
    }

    public static int Func(int n , String[] splits){
        int[] coins = new int[n];
        for(int i=0 ; i<n ; i++){
            coins[i] = Integer.parseInt(splits[i]);
        }
        int sum = Arrays.stream(coins).sum();
        int myCoin = 0;
        int count = 0;
        while(sum/2 >= myCoin){
            Integer[] tmp = Arrays.stream(coins).boxed().toArray(Integer[]::new);
            Arrays.sort(tmp, Collections.reverseOrder());
            myCoin += tmp[count];
            count++;
        }
        return count;
    }


}
