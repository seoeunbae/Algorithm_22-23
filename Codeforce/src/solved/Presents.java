package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0,0);
        for(int i=1; i<=n ;i++){
            int p = scanner.nextInt();
            list.add( i , p );
        }
        valueFunc(list);
    }

    public static void valueFunc(List<Integer> list){
        for(int value = 1; value<= list.size()-1; value++){
            System.out.print(list.indexOf(value));
            System.out.print(" ");
        }
    }
}
