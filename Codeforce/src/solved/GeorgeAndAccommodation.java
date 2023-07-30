package solved;

import java.util.Scanner;

public class GeorgeAndAccommodation {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i < n ;i++){
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            Func(p,q);
        }
        System.out.println(count);
    }

    public static void Func(int p, int q){
        int space = q-p;
        if(space>=2) count+=1;
    }

}
