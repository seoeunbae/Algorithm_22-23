package solved;

import java.util.Arrays;
import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer number = Integer.valueOf(scanner.nextLine());
        String stones = scanner.nextLine();
        System.out.println(Func(number,stones));
    }

    public static Integer Func(Integer number, String stones){
        char[] stoneChars = stones.toCharArray();
        char pre = stoneChars[0];
        Integer count = 0;

        for(int i=1;i< stoneChars.length; i++){

            if(stoneChars[i] == pre){
                stones = stones.replaceFirst(Character.toString(pre), "");
                System.out.println(stones);
                count++;
            }
            pre = stoneChars[i];
        }
        return count;
    }
}
//시간복잡도: O(stone의 개수)
//주제: 구현