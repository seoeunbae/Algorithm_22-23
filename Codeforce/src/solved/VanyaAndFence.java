package solved;

import java.util.Scanner;

public class VanyaAndFence {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int h = scanner.nextInt();

        System.out.println(Func(n , h));
    }

    public static Integer Func(int n, int h){
        int width = n;
        for( int i=0 ; i < n ;i++){
            int number = scanner.nextInt();
            if( number > h) width +=1;
        }
        return width;
    }
}
//O(n)
//구현