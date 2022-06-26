package solved;

import java.util.Scanner;

public class Tram {
    static int max;
    static int capacity;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        max = 0;
        for(int i =0 ; i < N ; i++){
            String[] num = scanner.nextLine().split(" ");
            if(num != null){
                findMaxCapacity(num);
            }

        }
        System.out.println(max);

    }

    public static void findMaxCapacity(String[] num){
        Integer minus = Integer.valueOf(num[0]);
        Integer plus = Integer.valueOf(num[1]);

        capacity = capacity-minus+plus;

        if( max < capacity){
            max = capacity;
        }
    }
}
//시간복잡도: O(N)
//주제: 구현