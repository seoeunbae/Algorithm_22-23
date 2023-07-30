package unsolved;

import java.util.Scanner;

public class BeautifulYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        System.out.println(Func(s));
    }
    public static int Func(int s){
       while(true){
           s+=1;
           int a = s / 1000;
           int b = s % 1000 / 100;
           int c = s % 100 / 10;
           int d = s % 10;
           if( a!= b && a!= c && a!= d && b != c && b!= d && c!= d){
               break;
           }
       }
       return s;
    }
}
