package solved;

import java.util.Scanner;

public class WrongSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        System.out.println(Func(split));
    }
    public static String Func(String[] split){
        int count = Integer.parseInt(split[1]);
        for(;count > 0;count--){
            if(split[0].toCharArray()[split[0].length()-1]=='0'){
                int num = Integer.parseInt(split[0]);
                num /= 10;
                split[0] = String.valueOf(num);

            } else {
                int num = Integer.parseInt(split[0]);
                num -= 1;
                split[0] = String.valueOf(num);
            }
        }
        return split[0];
    }
}
//시간복잡도: O(count)
//주제: 구현